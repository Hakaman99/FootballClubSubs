package com.example.root.submission1

import java.net.URL

class ApiRepository {
    fun doRequest(url:String):String{
        return URL(url).readText()
    }
}