package com.secodebase.data.persistences.mappers.basemapper

import com.secodebase.data.payload.responses.BaseResponse
import com.secodebase.domain.BaseResponseDomain

interface IBaseMapper<DATA> {
    fun toBaseResponseDomain(response: BaseResponse<DATA>): BaseResponseDomain
}