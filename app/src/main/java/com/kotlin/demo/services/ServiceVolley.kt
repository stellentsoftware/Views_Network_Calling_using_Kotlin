package com.kotlin.demo.services

import android.util.Log
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.VolleyLog
import com.android.volley.toolbox.JsonObjectRequest
import com.kotlin.demo.interfaces.ServiceInterface
import com.kotlin.demo.singleton.BackendVolley
import org.json.JSONObject

/**
 * Created by STELLENT on 12/13/2017.
 */
//ServiceVolley also complies to ServiceInterface
// and implements the actual Volley request.
class ServiceVolley : ServiceInterface {
    val TAG = ServiceVolley::class.java.simpleName
    val basePath = "http://freegeoip.net"

    override fun post(path: String, params: JSONObject, completionHandler: (response: JSONObject?) -> Unit) {
        val jsonObjReq = object : JsonObjectRequest(Method.GET, basePath + path, params,
                Response.Listener<JSONObject> { response ->
                    Log.d(TAG, "/post request OK! Response: $response")
                    completionHandler(response)
                },
                Response.ErrorListener { error ->
                    VolleyLog.e(TAG, "/post request fail! Error: ${error.message}")
                    completionHandler(null)
                }) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers.put("Content-Type", "application/json")
                return headers
            }
        }

        BackendVolley.instance?.addToRequestQueue(jsonObjReq, TAG)
    }
}