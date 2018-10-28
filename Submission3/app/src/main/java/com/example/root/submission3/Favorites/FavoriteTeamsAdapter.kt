package com.example.root.submission3.Favorites

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.root.submission3.Model.FavoriteTeams.Favorite
import com.example.root.submission3.R
import com.example.root.submission3.UI.TeamUI
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk27.coroutines.onClick

class FavoriteTeamsAdapter(private val favoriteTeamsAdapter: List<Favorite>, private val listener: (Favorite) -> Unit) :
        RecyclerView.Adapter<FavoriteTeamViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): FavoriteTeamViewHolder {
        return FavoriteTeamViewHolder(TeamUI().createView(AnkoContext.create(p0.context, p0)))
    }

    override fun getItemCount(): Int = favoriteTeamsAdapter.size

    override fun onBindViewHolder(p0: FavoriteTeamViewHolder, p1: Int) {
        p0.bindItems(favoriteTeamsAdapter[p1], listener)
    }

}

class FavoriteTeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvDateLeagueUI: TextView = view.find(R.id.tvDateLeagueUI)
    private val strHomeTeam: TextView = view.find(R.id.strHomeTeam)
    private val score: TextView = view.find(R.id.score)
    private val strAwayTeam: TextView = view.find(R.id.strAwayTeam)
    fun bindItems(teamsFavorite: Favorite, listener: (Favorite) -> Unit) {
        tvDateLeagueUI.text = teamsFavorite.dateEvent ?: ""
        strHomeTeam.text = teamsFavorite.homeTeam ?: ""
        score.text = "${teamsFavorite.homeScore ?: ""} VS ${teamsFavorite.awayScore ?: ""}"
        strAwayTeam.text = teamsFavorite.awayTeam ?: ""
        itemView.onClick {
            listener(teamsFavorite)
        }
    }
}