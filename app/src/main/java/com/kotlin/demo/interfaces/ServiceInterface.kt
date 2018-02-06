package com.kotlin.demo.interfaces

import org.json.JSONObject

/**
 * Created by STELLENT on 12/13/2017.
 */
//First comes the ServiceInterface which defines how we want our request to look like. In our case we start with a post request.

/*Notice that we pass a completionHandler so that we can handle the result
from where we called the request, rather than setting up interfaces for listeners on the network response.*/
interface ServiceInterface {
    fun post(path: String, params: JSONObject, completionHandler: (response: JSONObject?) -> Unit)
}
