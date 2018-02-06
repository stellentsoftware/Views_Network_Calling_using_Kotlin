package com.kotlin.demo.http



import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class ApiBuilder {
    private val BASE_URL = "https://api.github.com"
    private var retrofit: Retrofit? = null
    private val okHttpClient = OkHttpClient.Builder()


    fun createApiBuilder(): ApiInterface {
        setLogInterCeptor()
        val apiInterface: ApiInterface
        if (retrofit != null) {
            return retrofit!!.create(ApiInterface::class.java)
        } else {
            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                    // Set the okhttpclient and add default connect and read timepouts
                    .client(okHttpClient.connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            apiInterface = retrofit!!.create(ApiInterface::class.java)
            return apiInterface
        }
    }

    /**
     * Set log interceptor for logging the network response
     */
    private fun setLogInterCeptor() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpClient.addInterceptor(interceptor).build()
    }

}
