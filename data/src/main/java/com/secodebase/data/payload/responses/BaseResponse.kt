package com.secodebase.data.payload.responses

import com.google.gson.annotations.SerializedName

data class BaseResponse<DATA>(
    val page: Int? = null,
    @SerializedName("per_page")
    val perPage: Int? = null,
    val total: Int? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    val message : String? = null,
    val data: DATA? = null
) : BaseResponsePayload
