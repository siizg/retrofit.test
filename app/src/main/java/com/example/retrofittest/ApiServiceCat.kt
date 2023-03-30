package com.example.retrofittest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiServiceCat {
    @GET("fact")
    suspend fun getCatFact() : Cat

    companion object {
        var apiService : ApiServiceCat? = null
        fun getInstance() : ApiServiceCat {
            if(apiService == null) {
                try {
                    apiService = Retrofit.Builder().baseUrl("https://catfact.ninja/")
                        .addConverterFactory(GsonConverterFactory.create()).build()
                        .create(ApiServiceCat :: class.java)

                }
                catch (e : Exception) {

                }
            }
            return apiService!!
        }
    }
}