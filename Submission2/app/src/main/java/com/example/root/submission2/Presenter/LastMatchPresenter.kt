package com.example.root.submission2.Presenter

import com.example.root.submission2.Model.LastEventsLeague.LastEventsLeagueResponse
import com.example.root.submission2.Network.ApiRepository
import com.example.root.submission2.Network.TheSportDBApi
import com.example.root.submission2.View.LastMatchView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LastMatchPresenter(
        private val view: LastMatchView,
        private val apiRepository: ApiRepository,
        private val gson: Gson) {

    fun getLastEventsLeague(events: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getLastEventsLeague(events)),
                    LastEventsLeagueResponse::class.java)
            uiThread {
                view.hideLoading()
                view.showLastLeagueList(data.events)
            }
        }
    }
}