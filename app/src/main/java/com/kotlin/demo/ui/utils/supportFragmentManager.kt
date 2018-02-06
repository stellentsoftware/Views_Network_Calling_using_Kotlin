package com.kotlin.demo.ui.utils

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

/**
 * Created by STELLENT on 12/13/2017.
 */


inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().addToBackStack(null).commit()
}