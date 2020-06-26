package com.bewizyu.mvvmarchitecture.core.di

import com.bewizyu.mvvmarchitecture.core.common.net.ApiConfiguration
import com.bewizyu.mvvmarchitecture.core.home.domain.repository.HomeFeedRepository
import com.bewizyu.mvvmarchitecture.core.home.domain.repository.HomeFeedRepositoryImpl
import com.bewizyu.mvvmarchitecture.core.login.domain.repository.LoginRepository
import com.bewizyu.mvvmarchitecture.core.login.domain.repository.LoginRepositoryImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class
])
class AppModule {

    @Singleton
    @Provides
    fun provideOkhttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(ApiConfiguration.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(ApiConfiguration.BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideLoginRepository(): LoginRepository {
        return LoginRepositoryImpl()
    }

    @Singleton
    @Provides
    fun provideHomeRepository(): HomeFeedRepository {
        return HomeFeedRepositoryImpl()
    }



}