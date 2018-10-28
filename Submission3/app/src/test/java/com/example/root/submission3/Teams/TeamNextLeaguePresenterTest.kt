package com.example.root.submission3.Teams

import com.example.root.submission3.Model.TeamNextLeague.TeamNextLeague
import com.example.root.submission3.Model.TeamNextLeague.TeamNextLeagueResponse
import com.example.root.submission3.Network.ApiRepository
import com.example.root.submission3.Network.TheSportDBAPi
import com.example.root.submission3.Teams.TeamNextLeague.TeamNextLeaguePresenter
import com.example.root.submission3.TestContextProvider
import com.example.root.submission3.View.TeamNextLeagueView
import com.google.gson.Gson
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class TeamNextLeaguePresenterTest {
    @Mock
    private lateinit var viewTeamsNextLeague: TeamNextLeagueView
    @Mock
    private lateinit var gson: Gson
    @Mock
    private lateinit var apiRepository: ApiRepository


    private lateinit var presenterNextLeague: TeamNextLeaguePresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenterNextLeague = TeamNextLeaguePresenter(viewTeamsNextLeague, apiRepository, gson, TestContextProvider())
    }

    @Test
    fun testGetTeamListNextLeague() {
        val teamsNextLeague: MutableList<TeamNextLeague> = mutableListOf()
        val response = TeamNextLeagueResponse(teamsNextLeague)
        val league = "4328"

        Mockito.`when`(gson.fromJson(apiRepository
                .doRequest(TheSportDBAPi.getDataNextLeague(league)),
                TeamNextLeagueResponse::class.java
        )).thenReturn(response)

        presenterNextLeague.getTeamsNextLeague(league)

        Mockito.verify(viewTeamsNextLeague).showLoading()
        Mockito.verify(viewTeamsNextLeague).getTeamNextLeagueList(teamsNextLeague)
        Mockito.verify(viewTeamsNextLeague).hideLoading()
    }
}