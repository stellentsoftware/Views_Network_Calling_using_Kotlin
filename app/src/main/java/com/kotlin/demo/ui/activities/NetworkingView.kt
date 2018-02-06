package com.kotlin.demo.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.kotlin.demo.R
import com.kotlin.demo.controllers.APIController
import com.kotlin.demo.services.ServiceVolley
import kotlinx.android.synthetic.main.activity_networking_view.*
import org.json.JSONObject

class NetworkingView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_networking_view)

        ll_response.visibility = View.GONE
        text_network_error.visibility = View.GONE

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Volley"

        volleyRequest()

    }

    //Volley Request
    private fun volleyRequest() {
        val service = ServiceVolley()
        val apiController = APIController(service)
        val path = "/json"
        val params = JSONObject()
        apiController.post(path, params) { response ->
            progressBarNetworking.visibility = View.GONE
            if (response != null) {
                ll_response.visibility = View.VISIBLE
                text_network_error.visibility = View.GONE
                // Parse the result
                val jObj = JSONObject(response.toString())
                text_ip.text = jObj.getString("ip");
                text_latitude.text = jObj.getString("latitude");
                text_longitude.text = jObj.getString("longitude");
                text_country.text = jObj.getString("country_name");
            } else {

                ll_response.visibility = View.GONE
                text_network_error.visibility = View.VISIBLE
            }

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
