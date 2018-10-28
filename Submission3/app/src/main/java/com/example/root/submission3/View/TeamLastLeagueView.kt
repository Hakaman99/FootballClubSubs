package com.example.root.submission3.View

import com.example.root.submission3.Model.TeamLastLeague.TeamLastLeague

interface TeamLastLeagueView {
    fun hideLoading()
    fun showLoading()
    fun getTeamLastLeagueList(data: List<TeamLastLeague>)
}