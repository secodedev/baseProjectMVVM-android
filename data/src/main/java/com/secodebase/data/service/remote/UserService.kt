package com.secodebase.data.service.remote

import com.secodebase.data.payload.responses.BaseResponse
import com.secodebase.data.payload.responses.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserService {
    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int
    ): BaseResponse<List<UserResponse>>

    @GET("users/{id}")
    suspend fun getUserbyId(
        @Path("id") id: Int
    ): BaseResponse<UserResponse>
}