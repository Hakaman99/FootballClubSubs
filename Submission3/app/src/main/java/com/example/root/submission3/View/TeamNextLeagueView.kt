package com.example.root.submission3.View

import com.example.root.submission3.Model.TeamNextLeague.TeamNextLeague

interface TeamNextLeagueView {
    fun hideLoading()
    fun showLoading()
    fun getTeamNextLeagueList(data: List<TeamNextLeague>)
}