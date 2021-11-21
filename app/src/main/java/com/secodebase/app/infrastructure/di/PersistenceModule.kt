package com.secodebase.app.infrastructure.di

import com.secodebase.data.persistences.contracts.IUserPersistence
import com.secodebase.data.persistences.contracts.UserPersistence
import org.koin.dsl.module

val persistenceModules = module {
    single<IUserPersistence> { UserPersistence(get()) }
}