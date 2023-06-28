package com.example.innobuzzdemo.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Baseurl() {
    val base_url = "https://jsonplaceholder.typicode.com/"

    fun get_Instance(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}