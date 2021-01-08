package com.alpha.myapplication.api

import android.content.Context
import android.widget.LinearLayout
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

abstract class NasaAPI(ctx: Context) {
    private val apiKey : String = "afujVH1yfkEvT7CuDXcu4jiCPPbxkWtOpekQc5GW"
    private var requestQueue : RequestQueue = Volley.newRequestQueue(ctx)

    fun getAPIKey() : String = apiKey

    protected fun addQueue(request: JsonObjectRequest) {
        requestQueue.add(request)
    }

}