package com.secodebase.app.infrastructure.di

import com.secodebase.app.ui.viewmodels.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel { UserViewModel(get(), get()) }
}