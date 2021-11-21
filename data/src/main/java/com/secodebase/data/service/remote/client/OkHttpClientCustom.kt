package com.secodebase.data.service.remote.client

import android.content.Context
import com.secodebase.data.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.util.concurrent.TimeUnit

object OkHttpClientCustom {

    fun getClient(context: Context): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()

        if (!BuildConfig.IS_RELEASE) {
            val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            okHttpClientBuilder.addInterceptor(httpLoggingInterceptor)
        }

        okHttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS)
        okHttpClientBuilder.readTimeout(30, TimeUnit.SECONDS)
        okHttpClientBuilder.writeTimeout(30, TimeUnit.SECONDS)

        okHttpClientBuilder.addInterceptor { chain ->
            val mOriRequest: Request = chain.request()
            val request: Request = mOriRequest.newBuilder()
//                .addHeader("Authorization", "Bearer ${LoginHelper(context).getAuthToken()}")
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .method(mOriRequest.method, mOriRequest.body)
                .build()

            Timber.tag("Auth-request").d("header :  ${request.headers}")
            chain.proceed(request)
        }
        return okHttpClientBuilder.build()
    }
}