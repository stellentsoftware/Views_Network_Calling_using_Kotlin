package com.kotlin.demo.ui.activities

import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.kotlin.demo.R
import com.kotlin.demo.models.MyData
import com.kotlin.demo.ui.adapters.RecyclerViewAdapter

class RecyclerAndCardView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_and_card_view)

        val _recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        _recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val items = ArrayList<MyData>()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "RecyclerView"
        //Adding some dummy data to the list
        items.add(MyData("What is..", BitmapFactory.decodeResource(resources, R.drawable.album1)))
        items.add(MyData("No No..", BitmapFactory.decodeResource(resources, R.drawable.album2)))
        items.add(MyData("Going on..", BitmapFactory.decodeResource(resources, R.drawable.album3)))
        items.add(MyData("Keep it up..", BitmapFactory.decodeResource(resources, R.drawable.album4)))
        items.add(MyData("Don't say..", BitmapFactory.decodeResource(resources, R.drawable.album5)))
        items.add(MyData("What is..", BitmapFactory.decodeResource(resources, R.drawable.album6)))
        items.add(MyData("No No..", BitmapFactory.decodeResource(resources, R.drawable.album7)))
        items.add(MyData("Going on..", BitmapFactory.decodeResource(resources, R.drawable.album8)))
        items.add(MyData("Keep it up..", BitmapFactory.decodeResource(resources, R.drawable.album9)))
        items.add(MyData("Don't say..", BitmapFactory.decodeResource(resources, R.drawable.album10)))
        //Creating our adapter
        val adapter = RecyclerViewAdapter(items, this)

        //Now adding the adapter to recyclerview
        _recyclerView.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
