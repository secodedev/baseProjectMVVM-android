package com.secodebase.domain

data class BaseResponseDomain(
    var page: Int = 0,
    var perPage: Int = 0,
    var total: Int = 0,
    var totalPages: Int = 0,
    var message : String = "",
    var data: Any
)
