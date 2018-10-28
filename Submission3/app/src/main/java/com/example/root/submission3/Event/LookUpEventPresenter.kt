package com.example.root.submission3.Event

import com.example.root.submission3.Model.LookUpEvent.LookUpEventResponse
import com.example.root.submission3.Model.LookUpTeam.LookUpTeamResponse
import com.example.root.submission3.Network.ApiRepository
import com.example.root.submission3.Network.TheSportDBAPi
import com.example.root.submission3.Utils.CoroutineContextProvider
import com.example.root.submission3.View.LookUpEventView
import com.google.gson.Gson
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class LookUpEventPresenter(
        private val view: LookUpEventView,
        private val apiRepository: ApiRepository,
        private val gson: Gson,
        private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getLookUpEvent(id: String) {
        view.showLoading()
        async(context.main) {
            val data = bg {
                gson.fromJson(apiRepository
                        .doRequest(TheSportDBAPi.getDataLookUpEvent(id)),
                        LookUpEventResponse::class.java)
            }
            view.getLookUpEventList(data.await().events)
        }
    }

    fun getLookUpTeam(idHome: String, idAway: String) {
        async(context.main) {
            val data1 = bg {
                gson.fromJson(apiRepository
                        .doRequest(TheSportDBAPi.getDataLookUpTeam(idHome)),
                        LookUpTeamResponse::class.java)
            }

            val data2 = bg {
                gson.fromJson(apiRepository
                        .doRequest(TheSportDBAPi.getDataLookUpTeam(idAway)),
                        LookUpTeamResponse::class.java)
            }
            view.geLookUpTeamList(data1.await().teams, data2.await().teams)
            view.hideLoading()
        }
    }
}