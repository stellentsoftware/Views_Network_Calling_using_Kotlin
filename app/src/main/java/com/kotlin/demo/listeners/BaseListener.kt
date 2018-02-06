package com.kotlin.demo.listeners


import okhttp3.ResponseBody


interface BaseListener {

    interface OnWebServiceCompleteListener {

        fun onWebServiceComplete(baseObject: ResponseBody)

        // This method will fired when service status is false
        fun onWebStatusFalse(message: String)
    }
}