package com.kotlin.demo.http

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Requester {


    internal fun provideRetrofit(): Retrofit {
        val BASE_URL =  "http://192.168.1.91"

        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}