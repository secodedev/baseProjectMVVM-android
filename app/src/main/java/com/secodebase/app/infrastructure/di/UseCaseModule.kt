package com.secodebase.app.infrastructure.di

import com.secodebase.usecase.IUserUseCase
import com.secodebase.usecase.UserUseCase
import org.koin.dsl.module

val useCaseModules = module {
    single<IUserUseCase> { UserUseCase(get()) }
}