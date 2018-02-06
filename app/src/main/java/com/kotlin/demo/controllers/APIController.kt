package com.kotlin.demo.controllers

import com.kotlin.demo.interfaces.ServiceInterface
import org.json.JSONObject

/**
 * Created by STELLENT on 12/13/2017.
 */

/*APIController breaks the relationship between our “regular” code and our choice of networking library.
You can easily inject any other class following the ServiceInterface*/
class APIController constructor(serviceInjection: ServiceInterface) : ServiceInterface {
    private val service: ServiceInterface = serviceInjection

    override fun post(path: String, params: JSONObject, completionHandler: (response: JSONObject?) -> Unit) {
        service.post(path, params, completionHandler)
    }
}