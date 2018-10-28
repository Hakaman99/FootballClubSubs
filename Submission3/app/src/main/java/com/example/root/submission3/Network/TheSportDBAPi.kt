package com.example.root.submission3.Network

import com.example.root.submission3.BuildConfig

object TheSportDBAPi {
    fun getDataLastLeague(id: String?): String {
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/eventspastleague.php?id=" + id
    }

    fun getDataNextLeague(id: String): String {
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/eventsnextleague.php?id=" + id
    }

    fun getDataLookUpTeam(id: String): String {
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookupteam.php?id=" + id
    }

    fun getDataLookUpEvent(id: String): String {
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookupevent.php?id=" + id
    }
}