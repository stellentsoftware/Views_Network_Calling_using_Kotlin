package com.kotlin.demo.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.kotlin.demo.R
import com.kotlin.demo.bean.BaseBean
import com.kotlin.demo.bean.UserBean
import com.kotlin.demo.http.request.SimpleRequest
import com.kotlin.demo.listeners.ApiCallback
import com.kotlin.demo.ui.adapters.UsersAdapter
import kotlinx.android.synthetic.main.activity_netwroking_retrofit.*

class NetwrokingRetrofitView : AppCompatActivity(), ApiCallback {

    lateinit var userAdapter: UsersAdapter


    lateinit var userList: Array<UserBean>
    var request = SimpleRequest()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_netwroking_retrofit)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Retrofit"
        init()
    }

    fun init() = try {
        // Retrofit Request
        request.getGitUsers(1, this)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onRequestSuccess(bean: BaseBean) {
        Log.e("test", "success " + bean)
    }

    override fun onRequestFailed(message: String) {
        progressBarRetrofit.visibility = View.GONE
        Log.e("test", "request failed " + message)
    }

    override fun onUserSuccess(userBean: Array<UserBean>) {

        progressBarRetrofit.visibility = View.GONE
        userList = userBean
        userList = arrayOf(UserBean())
        //RecyclerView Adapter to display data
        userAdapter = UsersAdapter(userBean, this)
        recycler_view_retrofit.adapter = userAdapter
        val linearLayoutManager = LinearLayoutManager(this)
        recycler_view_retrofit.layoutManager = linearLayoutManager
        userAdapter.notifyDataSetChanged()
    }
}
