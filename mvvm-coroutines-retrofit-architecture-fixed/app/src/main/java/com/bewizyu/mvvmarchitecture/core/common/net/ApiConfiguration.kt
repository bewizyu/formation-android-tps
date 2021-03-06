package com.bewizyu.mvvmarchitecture.core.common.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

class ApiConfiguration {
    companion object API {
        private const val BASE_URL = "https://demo0635484.mockable.io/"
        private const val CONNECT_TIMEOUT: Long = 3000


        val retrofitInstance: Retrofit by lazy {
            buildRetrofit()
        }

        private fun buildRetrofit(): Retrofit {
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .build()


            return Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        }
    }


}