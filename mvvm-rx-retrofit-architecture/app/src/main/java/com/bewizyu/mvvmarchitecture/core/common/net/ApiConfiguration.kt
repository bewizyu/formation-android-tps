package com.bewizyu.mvvmarchitecture.core.common.net

import retrofit2.Retrofit

class ApiConfiguration {

    companion object API {
        private const val BASE_URL = "https://demo0635484.mockable.io/"
        private const val CONNECT_TIMEOUT: Long = 3000


        val retrofitInstance: Retrofit by lazy {
            buildRetrofit()
        }

        private fun buildRetrofit(): Retrofit {
            //TODO-2 : construire et retourner une instance de Retrofit
            // Ajouter à l'instance créée un call adapter de RxJava2 : RxJava2CallAdapterFactory.create()
            return TODO()
        }
    }
}