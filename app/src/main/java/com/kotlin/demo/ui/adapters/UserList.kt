package com.kotlin.demo.ui.adapters

/**
 * Created by STELLENT on 12/13/2017.
 */
import com.kotlin.demo.bean.UserBean

class UserList(val userList: List<UserBean>) {

    val size: Int
        get() = userList.size

    operator fun get(position: Int) = userList[position]
}