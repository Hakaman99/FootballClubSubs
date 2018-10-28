package com.example.root.submission2.Presenter

import com.example.root.submission2.Model.LookUpTeam.LookUpTeamResponse
import com.example.root.submission2.Network.ApiRepository
import com.example.root.submission2.Network.TheSportDBApi
import com.example.root.submission2.View.LookUpTeamView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LookUpTeamPresenter(
        private val view: LookUpTeamView,
        private val apiRepository: ApiRepository,
        private val gson: Gson) {

    fun getLookUpTeam(dataHome: String?, dataAway: String?) {
        view.showLoading()
        doAsync {
            val data1 = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getLookUpTeam(dataHome)),
                    LookUpTeamResponse::class.java)
            val data2 = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getLookUpTeam(dataAway)),
                    LookUpTeamResponse::class.java)
            uiThread {
                view.hideLoading()
                view.showLookUpTeam(data1.teams, data2.teams)
            }
        }
    }
}