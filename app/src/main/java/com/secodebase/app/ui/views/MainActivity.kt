package com.secodebase.app.ui.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.secodebase.app.databinding.ActivityMainBinding
import com.secodebase.app.ui.adapters.UserAdapter
import com.secodebase.app.ui.adapters.listener.OnLastItem
import com.secodebase.app.ui.utils.StatusUtil
import com.secodebase.app.ui.viewmodels.UserViewModel
import com.secodebase.domain.UserDomain
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModel()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { UserAdapter(listUser) }

    private val listUser = ArrayList<UserDomain>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getData()
        setObserver()
        setView()
    }

    private fun setView() {
        adapter.loadMoreListener(object : OnLastItem {
            override fun loadmore() {
                Toast.makeText(
                    this@MainActivity,
                    "loadmore = ${userViewModel.isLastPage}",
                    Toast.LENGTH_SHORT
                ).show()
                userViewModel.loadMoreListUser()
            }
        })
        binding.run {
            rvUser.adapter = adapter
            swipeRefresh.setOnRefreshListener {
                getData()
            }
        }
    }

    private fun setObserver() {
        listUserObserver()
    }

    private fun listUserObserver() {
        userViewModel.listUser.observe(this, { result ->
            when (result.status) {
                StatusUtil.LOADING -> {
                    Timber.tag("getListUsers").d("loading")
                }
                StatusUtil.SUCCESS -> {
                    binding.swipeRefresh.isRefreshing = false
                    Timber.tag("getListUsers").d("success , \n${result.data}")
                    setDataUser(result.data ?: emptyList())
                }
                StatusUtil.ERROR -> {
                    binding.swipeRefresh.isRefreshing = false
                    Timber.tag("getListUsers").d("error")
                }
                StatusUtil.CONNECTION_FAILED -> {
                    binding.swipeRefresh.isRefreshing = false
                    Timber.tag("getListUsers").d("no connection")
                }
            }
        })
    }

    private fun setDataUser(list: List<UserDomain>) {
        listUser.addAll(list)
        adapter.notifyDataSetChanged()
    }

    private fun getData() {
        listUser.clear()
        userViewModel.resetListUser()
    }
}