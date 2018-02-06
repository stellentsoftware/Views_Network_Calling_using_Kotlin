package com.kotlin.demo.http.request


import android.util.Log
import com.google.gson.GsonBuilder
import com.kotlin.demo.bean.UserBean
import com.kotlin.demo.http.ConnectionManager
import com.kotlin.demo.listeners.ApiCallback
import com.kotlin.demo.listeners.BaseListener
import okhttp3.ResponseBody
import org.json.JSONArray





class SimpleRequest : BaseRequest() {

    private val TAG = javaClass.simpleName

    /**
     *Try to login user on server with the username and password provided
     */
    fun getGitUsers(since : Int, callback: ApiCallback) {
        val callSaveRoute = apiClient.getGitUsers(since)
        val connectionManager = ConnectionManager.getConnectionInstance(callSaveRoute)
        connectionManager.callApi(object : BaseListener.OnWebServiceCompleteListener {
            override fun onWebServiceComplete(baseObject: ResponseBody) {
                try {
                val jsonObject = JSONArray(baseObject.string())
                    Log.e("git response ", " "+jsonObject.toString())
                    val gsonBuilder = GsonBuilder()
                    val gson = gsonBuilder.create()
                    val testCase = gson.fromJson(jsonObject.toString(), Array<UserBean>::class.java)
                    callback.onUserSuccess(testCase)
                } catch (exp: Exception) {
                    exp.printStackTrace()
                    callback.onRequestFailed("Error occurred while parsing")
                }

            }

            override fun onWebStatusFalse(message: String) {
                callback.onRequestFailed(message)
            }
        })
    }
}
