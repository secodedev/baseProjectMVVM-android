package com.secodebase.data.persistences.mappers.basemapper

import com.secodebase.data.payload.responses.BaseResponse
import com.secodebase.domain.BaseResponseDomain

class BaseMapper<DATA> : IBaseMapper<DATA> {
    override fun toBaseResponseDomain(response: BaseResponse<DATA>): BaseResponseDomain {
        return BaseResponseDomain(
            response.page ?: 0,
            response.perPage ?: 0,
            response.total ?: 0,
            response.totalPages ?: 0,
            response.message ?: "",
            response . data ?: ""
        )
    }
}