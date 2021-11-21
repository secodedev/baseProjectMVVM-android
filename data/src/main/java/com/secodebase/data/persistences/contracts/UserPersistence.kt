package com.secodebase.data.persistences.contracts

import com.secodebase.data.payload.responses.BaseResponse
import com.secodebase.data.payload.responses.UserResponse
import com.secodebase.data.service.remote.UserService

class UserPersistence(
    private val service: UserService
) : IUserPersistence {
    override suspend fun getUsers(payload: Int): BaseResponse<List<UserResponse>> =
        service.getUsers(payload)

    override suspend fun getUserbyId(payload: Int): BaseResponse<UserResponse> =
        service.getUserbyId(payload)

}