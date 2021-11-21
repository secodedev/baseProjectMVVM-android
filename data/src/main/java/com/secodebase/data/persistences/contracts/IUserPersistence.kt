package com.secodebase.data.persistences.contracts

import com.secodebase.data.payload.responses.BaseResponse
import com.secodebase.data.payload.responses.UserResponse

interface IUserPersistence {
    suspend fun getUsers(payload : Int) : BaseResponse<List<UserResponse>>
    suspend fun getUserbyId(payload : Int) : BaseResponse<UserResponse>
}