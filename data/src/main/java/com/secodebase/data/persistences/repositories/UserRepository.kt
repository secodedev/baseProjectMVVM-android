package com.secodebase.data.persistences.repositories

import com.secodebase.data.payload.responses.BaseResponse
import com.secodebase.data.payload.responses.UserResponsePayload
import com.secodebase.data.persistences.contracts.IUserPersistence
import com.secodebase.data.persistences.mappers.usermapper.IUserMapper
import com.secodebase.domain.BaseResponseDomain

class UserRepository(
    private val persistence : IUserPersistence,
    private val userMapper : IUserMapper
) : IUserRepository {
    override suspend fun getUsers(payload: Int): BaseResponseDomain {
        val persistenceImpl = persistence.getUsers(payload)
        return userMapper.toListBaseUserDomain(persistenceImpl as BaseResponse<List<UserResponsePayload>>)
    }

    override suspend fun getUserbyId(payload: Int): BaseResponseDomain {
        val persistenceImpl = persistence.getUserbyId(payload)
        return userMapper.toBaseUserDomain(persistenceImpl as BaseResponse<UserResponsePayload>)
    }
}