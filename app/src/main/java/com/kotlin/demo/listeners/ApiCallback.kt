package com.kotlin.demo.listeners

import com.kotlin.demo.bean.BaseBean
import com.kotlin.demo.bean.UserBean




interface ApiCallback {
    fun onRequestSuccess(bean: BaseBean)
    fun onRequestFailed(message: String)
    fun onUserSuccess( userBean : Array<UserBean>)
}
