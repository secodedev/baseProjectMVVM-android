package com.secodebase.data.persistences.mappers.usermapper

import com.secodebase.data.payload.responses.BaseResponse
import com.secodebase.data.payload.responses.UserResponsePayload
import com.secodebase.domain.BaseResponseDomain
import com.secodebase.domain.UserDomain

interface IUserMapper {

    fun toUserDomain(response : UserResponsePayload) : UserDomain
    fun toListUserDomain(response: List<UserResponsePayload>) : List<UserDomain>

    fun toBaseUserDomain(response: BaseResponse<UserResponsePayload>) : BaseResponseDomain
    fun toListBaseUserDomain(response: BaseResponse<List<UserResponsePayload>>) : BaseResponseDomain

}