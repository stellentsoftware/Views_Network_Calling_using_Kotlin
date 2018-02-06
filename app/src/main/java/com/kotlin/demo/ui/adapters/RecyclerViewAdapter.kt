package com.kotlin.demo.ui.adapters

/**
 * Created by STELLENT on 12/12/2017.
 */
import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.kotlin.demo.R
import com.kotlin.demo.models.MyData

class RecyclerViewAdapter(val list: ArrayList<MyData>, val activity: Activity) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    public var context: Context = activity
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_recycler_card, parent, false)
        return ViewHolder(v)
    }

    //This method is binding the data on the list
    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.bindItems(list[position], context)
    }

    //This method is giving the size of the list
    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItems(data: MyData, context: Context) {
            val _textView: TextView = itemView.findViewById(R.id.textview)
            val _imageView: ImageView = itemView.findViewById(R.id.imageview)
            _textView.text = data.text
            _imageView.setImageBitmap(data.image)

            //Set the onclick listener for the singlt list item
            itemView.setOnClickListener({
                Log.e("ItemClicked", data.text)



                Toast.makeText(context, data.text, Toast.LENGTH_SHORT).show()
            })
        }

    }
}