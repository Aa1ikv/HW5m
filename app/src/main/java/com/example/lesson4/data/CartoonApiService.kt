package com.example.lesson4.data

import retrofit2.Call
import retrofit2.http.GET
import com.example.lesson4.model.BaseResponce

interface CartoonApiService {

        @GET("character")
        fun getCharacters(): Call<BaseResponce>

}
