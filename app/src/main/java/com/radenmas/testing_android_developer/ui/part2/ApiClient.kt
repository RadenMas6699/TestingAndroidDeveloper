package com.radenmas.testing_android_developer.ui.part2

import com.radenmas.testing_android_developer.model.ResponseJokes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by RadenMas on 13/12/2022.
 */
interface ApiClient {
    @GET("search")
    fun jokes(@Query("query") query: String): Call<ResponseJokes>
}