package com.example.root.submission3.Teams.TeamNextLeague

import com.example.root.submission3.Model.TeamNextLeague.TeamNextLeagueResponse
import com.example.root.submission3.Network.ApiRepository
import com.example.root.submission3.Network.TheSportDBAPi
import com.example.root.submission3.Utils.CoroutineContextProvider
import com.example.root.submission3.View.TeamNextLeagueView
import com.google.gson.Gson
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class TeamNextLeaguePresenter(
        private val view: TeamNextLeagueView,
        private val apiRepository: ApiRepository,
        private val gson: Gson,
        private val context: CoroutineContextProvider = CoroutineContextProvider()) {
    fun getTeamsNextLeague(id: String) {
        view.showLoading()
        async(context.main) {
            val data = bg {
                gson.fromJson(apiRepository
                        .doRequest(TheSportDBAPi.getDataNextLeague(id)),
                        TeamNextLeagueResponse::class.java)
            }
            view.getTeamNextLeagueList(data.await().events)
            view.hideLoading()
        }
    }
}