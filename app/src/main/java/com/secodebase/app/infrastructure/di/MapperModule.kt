package com.secodebase.app.infrastructure.di

import com.secodebase.data.persistences.mappers.basemapper.BaseMapper
import com.secodebase.data.persistences.mappers.basemapper.IBaseMapper
import com.secodebase.data.persistences.mappers.usermapper.IUserMapper
import com.secodebase.data.persistences.mappers.usermapper.UserMapper
import org.koin.dsl.module

val mapperModules = module {

    single<IBaseMapper<Any>> { BaseMapper() }
    single<IUserMapper> { UserMapper(get()) }

}

