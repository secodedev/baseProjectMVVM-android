package com.secodebase.app.infrastructure.di

import com.secodebase.data.persistences.repositories.IUserRepository
import com.secodebase.data.persistences.repositories.UserRepository
import org.koin.dsl.module

val repositoryModules = module {

    single<IUserRepository> { UserRepository(get(),get()) }

}