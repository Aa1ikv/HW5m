package com.example.lesson4.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

val api: CartoonApiService = Retrofit.Builder()
    .baseUrl("https://rickandmortyapi.com/api")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(CartoonApiService::class.java)
}