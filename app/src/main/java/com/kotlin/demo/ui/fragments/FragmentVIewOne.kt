package com.kotlin.demo.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.demo.R
import com.kotlin.demo.ui.utils.inTransaction
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.custom_fragment_layout.*



class FragmentVIewOne : Fragment() {

    companion object {

        fun newInstance(): FragmentVIewOne {
            return FragmentVIewOne()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        activity.toolbar.title = "Fragment One"

        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.custom_fragment_layout, container, false)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        fragment_one.setOnClickListener {
            // Handler code here.
            activity.supportFragmentManager.inTransaction {
                replace(R.id.fragment_container, FragmentViewTwo.newInstance())
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }


}
