package com.example.root.submission2.View

import com.example.root.submission2.Model.LookUpTeam.LookUpTeam

interface LookUpTeamView {
    fun showLoading()
    fun hideLoading()
    fun showLookUpTeam(dataHome:List<LookUpTeam>, dataAway:List<LookUpTeam>)
}