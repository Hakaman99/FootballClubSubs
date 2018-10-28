package com.example.root.submission2.View

import com.example.root.submission2.Model.LastEventsLeague.LastEventsLeague

interface LastMatchView{
    fun showLoading()
    fun hideLoading()
    fun showLastLeagueList(data:List<LastEventsLeague>)
}