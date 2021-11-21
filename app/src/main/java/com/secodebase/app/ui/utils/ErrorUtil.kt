package com.secodebase.app.ui.utils

import com.google.gson.Gson
import com.secodebase.domain.BaseResponseDomain


object ErrorUtil {
    fun errorMessage(responseBody: String?): BaseResponseDomain {
        return try {
            Gson().fromJson(responseBody, BaseResponseDomain::class.java)
        }catch (e: Exception){
            BaseResponseDomain(data = "", message = "Server Error")
        }
    }
}