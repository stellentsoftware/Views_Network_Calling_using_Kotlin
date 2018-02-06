package com.kotlin.demo.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kotlin.demo.R
import kotlinx.android.synthetic.main.app_bar_main.*



class FragmentViewTwo : Fragment() {
    companion object {

        fun newInstance(): FragmentViewTwo {
            return FragmentViewTwo()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activity.toolbar.title = "Fragment Two"
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_view_two, container, false)
    }

}
