package com.secodebase.app.ui.utils

enum class StatusUtil {
    SUCCESS,
    ERROR,
    LOADING,
    CONNECTION_FAILED
}

data class StateResultUtil<out T>(val status: StatusUtil, val data: T?, val message: String?){

    companion object{

        fun <T> success(msg: String?, data: T?): StateResultUtil<T> {
            return StateResultUtil(StatusUtil.SUCCESS, data, msg)
        }

        fun <T> error(msg: String, data: T?): StateResultUtil<T> {
            return StateResultUtil(StatusUtil.ERROR, data, msg)
        }

        fun <T> loading(msg: String?, data: T?): StateResultUtil<T> {
            return StateResultUtil(StatusUtil.LOADING, data, msg)
        }

        fun <T> connectionFailed(msg: String?, data: T? = null): StateResultUtil<T> {
            return StateResultUtil(StatusUtil.CONNECTION_FAILED,data, msg)
        }
    }
}