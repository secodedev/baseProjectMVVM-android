package com.secodebase.data.persistences.repositories

import com.secodebase.domain.BaseResponseDomain

interface IUserRepository {
    suspend fun getUsers(payload: Int): BaseResponseDomain
    suspend fun getUserbyId(payload: Int): BaseResponseDomain
}