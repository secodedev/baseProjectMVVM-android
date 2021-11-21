package com.secodebase.usecase

import com.secodebase.data.persistences.repositories.IUserRepository
import com.secodebase.domain.BaseResponseDomain

class UserUseCase(
    private val repository: IUserRepository
) : IUserUseCase {
    override suspend fun getUsers(payload: Int): BaseResponseDomain =
        repository.getUsers(payload)

    override suspend fun getUserbyId(payload: Int): BaseResponseDomain =
        repository.getUserbyId(payload)
}