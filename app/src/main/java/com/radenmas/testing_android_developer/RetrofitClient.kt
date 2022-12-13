package com.radenmas.testing_android_developer

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by RadenMas on 13/12/2022.
 */
object RetrofitClient {
    val instance: ApiClient by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiClient::class.java)
    }
}