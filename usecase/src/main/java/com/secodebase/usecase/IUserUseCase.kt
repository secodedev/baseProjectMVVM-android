package com.secodebase.usecase

import com.secodebase.domain.BaseResponseDomain

interface IUserUseCase {
    suspend fun getUsers(payload: Int): BaseResponseDomain
    suspend fun getUserbyId(payload: Int): BaseResponseDomain
}