package com.example.root.submission3.Teams

import com.example.root.submission3.Event.LookUpEventPresenter
import com.example.root.submission3.Model.LookUpEvent.LookUpEvent
import com.example.root.submission3.Model.LookUpEvent.LookUpEventResponse
import com.example.root.submission3.Model.LookUpTeam.LookUpTeam
import com.example.root.submission3.Model.LookUpTeam.LookUpTeamResponse
import com.example.root.submission3.Network.ApiRepository
import com.example.root.submission3.Network.TheSportDBAPi
import com.example.root.submission3.TestContextProvider
import com.example.root.submission3.View.LookUpEventView
import com.google.gson.Gson
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class LookUpEventTest {
    @Mock
    private lateinit var view: LookUpEventView
    @Mock
    private lateinit var gson: Gson
    @Mock
    private lateinit var apiRepository: ApiRepository

    private lateinit var presenter: LookUpEventPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = LookUpEventPresenter(view, apiRepository, gson, TestContextProvider())
    }

    @Test
    fun testGetLookUpEvent() {
        val teamsLookUpEvent: MutableList<LookUpEvent> = mutableListOf()
        val teamsLookUp1: MutableList<LookUpTeam> = mutableListOf()
        val response1 = LookUpEventResponse(teamsLookUpEvent)
        val response2 = LookUpTeamResponse(teamsLookUp1)
        val idLookUpEvent = "1234"
        val idLookUpTeam = "1234"

        Mockito.`when`(gson.fromJson(apiRepository
                .doRequest(TheSportDBAPi.getDataLookUpEvent(idLookUpEvent)),
                LookUpEventResponse::class.java
        )).thenReturn(response1)

        Mockito.`when`(gson.fromJson(apiRepository
                .doRequest(TheSportDBAPi.getDataLookUpTeam(idLookUpTeam)),
                LookUpTeamResponse::class.java
        )).thenReturn(response2)

        presenter.getLookUpEvent(idLookUpEvent)
        presenter.getLookUpTeam(idLookUpTeam,idLookUpTeam)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).getLookUpEventList(teamsLookUpEvent)
        Mockito.verify(view).geLookUpTeamList(response2.teams, response2.teams)
        Mockito.verify(view).hideLoading()
    }


}