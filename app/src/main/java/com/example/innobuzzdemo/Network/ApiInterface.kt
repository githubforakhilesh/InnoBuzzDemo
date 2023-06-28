package com.example.innobuzzdemo.Network

import com.example.innobuzzdemo.DataClass.MyDataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
@GET("posts")
fun get_List():Call<MyDataClass>
}