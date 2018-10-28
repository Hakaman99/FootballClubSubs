package com.example.root.submission2.Network

import android.net.Uri
import android.util.Log
import com.example.root.submission2.BuildConfig

object TheSportDBApi {
    //https://www.thesportsdb.com/api/v1/json/1/lookupteam.php?id=134301
    fun getLookUpTeam(eventID:String?):String{
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.TSDB_API_KEY)
                .appendPath("lookupteam.php")
                .appendQueryParameter("id",eventID)
                .build()
                .toString()
    }


    //    https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=4328
    fun getNextEventsLeague(eventID: String?): String {

        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.TSDB_API_KEY)
                .appendPath("eventsnextleague.php")
                .appendQueryParameter("id", eventID)
                .build()
                .toString()
    }

    //    https://www.thesportsdb.com/api/v1/json/1/eventspastleague.php?id=4328
    fun getLastEventsLeague(eventID: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.TSDB_API_KEY)
                .appendPath("eventspastleague.php")
                .appendQueryParameter("id", eventID)
                .build()
                .toString()

    }



}