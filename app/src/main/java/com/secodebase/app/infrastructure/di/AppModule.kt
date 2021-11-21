package com.secodebase.app.infrastructure.di

import android.content.Context
import com.secodebase.app.ui.utils.NetworkUtil
import com.secodebase.data.BuildConfig.BASE_URL_API
import com.secodebase.data.service.remote.UserService
import com.secodebase.data.service.remote.client.OkHttpClientCustom
import com.secodebase.data.service.remote.client.RetrofitClient
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit

val appModules = module {

    single { provideNetworkUtil(androidContext()) }
    single { provideOkHttppClient(androidContext()) }
    single { provideRetrofitClient(get(), BASE_URL_API) }

    single { provideUserRequest(get()) }

}

private fun provideNetworkUtil(context: Context) = NetworkUtil(context)
private fun provideRetrofitClient(okHttpClient: OkHttpClient, baseUrl: String) =
    RetrofitClient.getClient(okHttpClient, baseUrl)

private fun provideOkHttppClient(context: Context) = OkHttpClientCustom.getClient(context)

private fun provideUserRequest(retrofit: Retrofit): UserService =
    retrofit.create(UserService::class.java)