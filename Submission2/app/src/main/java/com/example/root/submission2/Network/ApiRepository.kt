package com.example.root.submission2.Network

import java.net.URL

class ApiRepository {
    fun doRequest(url:String):String{
        return URL(url).readText()
    }
}