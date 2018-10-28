package com.example.root.submission3.Teams

import com.example.root.submission3.Model.TeamLastLeague.TeamLastLeague
import com.example.root.submission3.Model.TeamLastLeague.TeamLastLeagueResponse
import com.example.root.submission3.Network.ApiRepository
import com.example.root.submission3.Network.TheSportDBAPi
import com.example.root.submission3.Teams.TeamLastLeague.TeamLastLeaguePresenter
import com.example.root.submission3.TestContextProvider
import com.example.root.submission3.View.TeamLastLeagueView
import com.google.gson.Gson
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class TeamLastLeaguePresenterTest {
    @Mock
    private lateinit var viewTeamsLastLeague: TeamLastLeagueView
    @Mock
    private lateinit var gson: Gson
    @Mock
    private lateinit var apiRepository: ApiRepository

    private lateinit var presenterLastLeague: TeamLastLeaguePresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenterLastLeague = TeamLastLeaguePresenter(viewTeamsLastLeague, apiRepository, gson, TestContextProvider())
    }

    @Test
    fun testGetTeamListLastLeague() {
        val teamsLastLeague: MutableList<TeamLastLeague> = mutableListOf()
        val response = TeamLastLeagueResponse(teamsLastLeague)
        val league = "4328"
        `when`(gson.fromJson(apiRepository
                .doRequest(TheSportDBAPi.getDataLastLeague(league)),
                TeamLastLeagueResponse::class.java
        )).thenReturn(response)

        presenterLastLeague.getTeamLastLeague(league)

        verify(viewTeamsLastLeague).showLoading()
        verify(viewTeamsLastLeague).getTeamLastLeagueList(teamsLastLeague)
        verify(viewTeamsLastLeague).hideLoading()
    }

}