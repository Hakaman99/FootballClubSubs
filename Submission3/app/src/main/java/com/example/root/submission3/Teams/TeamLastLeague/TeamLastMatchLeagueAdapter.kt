package com.example.root.submission3.Teams.TeamLastLeague

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.root.submission3.Model.TeamLastLeague.TeamLastLeague
import com.example.root.submission3.R
import com.example.root.submission3.UI.TeamUI
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk27.coroutines.onClick

class TeamLastMatchLeagueAdapter(private val teamsLastMatch: List<TeamLastLeague>, private val listener: (TeamLastLeague) -> Unit)
    : RecyclerView.Adapter<TeamLastMatchViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TeamLastMatchViewHolder {
        return TeamLastMatchViewHolder(TeamUI().createView(AnkoContext.create(p0.context, p0)))
    }

    override fun getItemCount(): Int = teamsLastMatch.size

    override fun onBindViewHolder(p0: TeamLastMatchViewHolder, p1: Int) {
        p0.bindItems(teamsLastMatch[p1], listener)
    }

}

class TeamLastMatchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvDateLeagueUI: TextView = view.find(R.id.tvDateLeagueUI)
    private val strHomeTeam: TextView = view.find(R.id.strHomeTeam)
    private val score: TextView = view.find(R.id.score)
    private val strAwayTeam: TextView = view.find(R.id.strAwayTeam)
    fun bindItems(teamsLastMatch: TeamLastLeague, listener: (TeamLastLeague) -> Unit) {
        tvDateLeagueUI.text = teamsLastMatch.dateEvent ?: ""
        strHomeTeam.text = teamsLastMatch.homeTeam ?: ""
        score.text = "${teamsLastMatch.homeScore ?: ""} VS ${teamsLastMatch.awayScore ?: ""}"
        strAwayTeam.text = teamsLastMatch.awayTeam ?: ""
        itemView.onClick {
            listener(teamsLastMatch)
        }
    }

}
