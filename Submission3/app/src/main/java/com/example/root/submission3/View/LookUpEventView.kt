package com.example.root.submission3.View

import com.example.root.submission3.Model.LookUpEvent.LookUpEvent
import com.example.root.submission3.Model.LookUpTeam.LookUpTeam

interface LookUpEventView {
    fun showLoading()
    fun hideLoading()
    fun getLookUpEventList(data: List<LookUpEvent>)
    fun geLookUpTeamList(dataHome: List<LookUpTeam>, dataAway: List<LookUpTeam>)
}