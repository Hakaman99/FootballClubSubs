package com.example.root.submission3.Teams.TeamNextLeague

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.root.submission3.Model.TeamNextLeague.TeamNextLeague
import com.example.root.submission3.R
import com.example.root.submission3.UI.TeamUI
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk27.coroutines.onClick

class TeamsNextMatchLeagueAdapter(private val teamsNextMatch: List<TeamNextLeague>, private val listener: (TeamNextLeague) -> Unit) :
        RecyclerView.Adapter<TeamNextViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TeamNextViewHolder {
        return TeamNextViewHolder(TeamUI().createView(AnkoContext.create(p0.context, p0)))
    }

    override fun getItemCount(): Int = teamsNextMatch.size

    override fun onBindViewHolder(p0: TeamNextViewHolder, p1: Int) {
        p0.bindItems(teamsNextMatch[p1], listener)
    }
}

class TeamNextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvDateLeagueUI: TextView = view.find(R.id.tvDateLeagueUI)
    private val strHomeTeam: TextView = view.find(R.id.strHomeTeam)
    private val score: TextView = view.find(R.id.score)
    private val strAwayTeam: TextView = view.find(R.id.strAwayTeam)
    fun bindItems(teamNextMatch: TeamNextLeague, listener: (TeamNextLeague) -> Unit) {
        tvDateLeagueUI.text = teamNextMatch.dateEvent ?: ""
        strHomeTeam.text = teamNextMatch.homeTeam ?: ""
        score.text = "${teamNextMatch.homeScore ?: ""} VS ${teamNextMatch.awayScore ?: ""}"
        strAwayTeam.text = teamNextMatch.awayTeam ?: ""
        itemView.onClick {
            listener(teamNextMatch)
        }
    }

}
