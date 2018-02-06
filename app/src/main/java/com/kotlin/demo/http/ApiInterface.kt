package com.kotlin.demo.http


import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query




interface ApiInterface {

    @GET("/users")
    fun getGitUsers(@Query("since") since: Int): Call<ResponseBody>

}
