package com.example.root.submission2.View

import com.example.root.submission2.Model.NextEventsLeague.NextEventsLeague

interface NextMatchView{
    fun showLoading()
    fun hideLoading()
    fun showNextMatchView(data:List<NextEventsLeague>)
}