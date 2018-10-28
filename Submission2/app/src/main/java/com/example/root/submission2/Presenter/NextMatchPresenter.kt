package com.example.root.submission2.Presenter

import com.example.root.submission2.Model.NextEventsLeague.NextEventsLeague
import com.example.root.submission2.Model.NextEventsLeague.NextEventsLeagueResponse
import com.example.root.submission2.Network.ApiRepository
import com.example.root.submission2.Network.TheSportDBApi
import com.example.root.submission2.View.NextMatchView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class NextMatchPresenter(private val view: NextMatchView,
                         private val apiRepository: ApiRepository,
                         private val gson: Gson) {
    fun getNextEventsLeague(events: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getNextEventsLeague(events)),
                    NextEventsLeagueResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showNextMatchView(data.events)
            }
        }
    }
}