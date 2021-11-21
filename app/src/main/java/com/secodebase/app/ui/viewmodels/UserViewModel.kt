package com.secodebase.app.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.secodebase.app.ui.utils.ErrorUtil
import com.secodebase.app.ui.utils.NetworkUtil
import com.secodebase.app.ui.utils.StateResultUtil
import com.secodebase.domain.UserDomain
import com.secodebase.usecase.IUserUseCase
import kotlinx.coroutines.launch
import retrofit2.HttpException

class UserViewModel(
    private val userUseCase: IUserUseCase,
    private val networkUtil: NetworkUtil
) : ViewModel() {

    //region call coroutine
    private fun callCoroutine(
        coroutine: suspend () -> Unit,
        httpErrorCallback: (code: Int, responseBody: String?) -> Unit,
        exception: (String?) -> Unit
    ) {
        viewModelScope.launch {
            try {
                coroutine()
            } catch (error: HttpException) {
                val response = error.response()?.errorBody()?.string()
                httpErrorCallback(error.code(), response)
            } catch (error: Exception) {
                exception(error.localizedMessage)
            }
        }
    }
    //endregion

    private var currentPage = 1
    var isLastPage = false

    private val _listUsers = MutableLiveData<StateResultUtil<List<UserDomain>>>()
    val listUser: LiveData<StateResultUtil<List<UserDomain>>>
        get() = _listUsers

    fun resetListUser() {
        isLastPage = false
        currentPage = 1
        getListUser(currentPage)
    }

    fun loadMoreListUser() {
        if (!isLastPage) {
            getListUser(currentPage)
        }
    }

    private fun getListUser(page: Int = 1) {
        _listUsers.postValue(StateResultUtil.loading("Loading", null))

        if (networkUtil.isNetworkConnected()) {
            callCoroutine({
                val response = userUseCase.getUsers(page)
                val data = response.data as List<UserDomain>

                if (currentPage < response.totalPages) {
                    currentPage++
                } else {
                    isLastPage = true
                }
                _listUsers.postValue(StateResultUtil.success("Success", data))
            }, { code, responseBody ->
                val err = ErrorUtil.errorMessage(responseBody).message
                _listUsers.postValue(StateResultUtil.error(err, null))
            }, { e ->
                val err = e ?: "Error Exception"
                _listUsers.postValue(StateResultUtil.error(err, null))
            })
        } else {
            _listUsers.postValue(StateResultUtil.connectionFailed("No Connection", null))
        }
    }
}