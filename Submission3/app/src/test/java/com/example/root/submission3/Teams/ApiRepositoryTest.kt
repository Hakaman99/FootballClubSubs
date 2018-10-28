package com.example.root.submission3.Teams

import com.example.root.submission3.Network.ApiRepository
import com.example.root.submission3.Network.TheSportDBAPi
import com.example.root.submission3.Utils.Constant
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class ApiRepositoryTest {
    @Test
    fun testLastLeagueDoRequest() {
        val apiRepository = mock(ApiRepository::class.java)
        val url = TheSportDBAPi.getDataLastLeague(Constant.ID_LAST_MATCH)
        apiRepository.doRequest(url)
        verify(apiRepository).doRequest(url)
    }

    @Test
    fun testNextLeagueDoRequest() {
        val apiRepository = mock(ApiRepository::class.java)
        val url = TheSportDBAPi.getDataNextLeague(Constant.ID_NEXT_MATCH)
        apiRepository.doRequest(url)
        verify(apiRepository).doRequest(url)
    }

    @Test
    fun testLookUpTeamDoRequest() {
        val apiRepository = mock(ApiRepository::class.java)
        val url = TheSportDBAPi.getDataLookUpTeam(Constant.ID_LOOK_UP_TEAM)
        apiRepository.doRequest(url)
        verify(apiRepository).doRequest(url)
    }

    @Test
    fun testLookUpEventDoRequest() {
        val apiRepository = mock(ApiRepository::class.java)
        val url = TheSportDBAPi.getDataLookUpTeam(Constant.ID_LOOK_UP_EVENT)
        apiRepository.doRequest(url)
        verify(apiRepository).doRequest(url)
    }
}