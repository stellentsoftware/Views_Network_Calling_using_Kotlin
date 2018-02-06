package com.kotlin.demo.http.request

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kotlin.demo.http.ApiBuilder
import com.kotlin.demo.http.ApiInterface


open class BaseRequest {

    var DATA = "data"
    var MESSAGE = "message"
    var STATUS = "status"

    /**
     * provides api client for making requests
     * @return Builder instance for making requests.
     */
    val apiClient: ApiInterface
        get() = ApiBuilder().createApiBuilder()

    /**
     * Provides GSON builder for casting response.
     * @return Gson.
     */
    val gsonBuilder: Gson
        get() {
            val gson = GsonBuilder().create()
            gson.serializeNulls()
            return gson
        }
}
