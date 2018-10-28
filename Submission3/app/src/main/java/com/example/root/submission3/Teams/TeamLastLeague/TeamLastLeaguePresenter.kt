package com.example.root.submission3.Teams.TeamLastLeague

import com.example.root.submission3.Model.TeamLastLeague.TeamLastLeagueResponse
import com.example.root.submission3.Network.ApiRepository
import com.example.root.submission3.Network.TheSportDBAPi
import com.example.root.submission3.Utils.CoroutineContextProvider
import com.example.root.submission3.View.TeamLastLeagueView
import com.google.gson.Gson
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class TeamLastLeaguePresenter(
        private val view: TeamLastLeagueView,
        private val apiRepository: ApiRepository,
        private val gson: Gson,
        private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getTeamLastLeague(id: String) {
        view.showLoading()
        async(context.main) {
            val data = bg {
                gson.fromJson(apiRepository
                        .doRequest(TheSportDBAPi.getDataLastLeague(id)),
                        TeamLastLeagueResponse::class.java)
            }
            view.getTeamLastLeagueList(data.await().events)
            view.hideLoading()
        }
    }
}