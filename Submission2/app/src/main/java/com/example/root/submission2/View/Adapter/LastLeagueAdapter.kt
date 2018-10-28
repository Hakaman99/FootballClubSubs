package com.example.root.submission2.View.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.root.submission2.Model.LastEventsLeague.LastEventsLeague
import com.example.root.submission2.Model.NextEventsLeague.NextEventsLeague
import com.example.root.submission2.R
import com.example.root.submission2.View.Fragment.FragmentUI.ListLeagueUI
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class LastLeagueAdapter(private val nextLeague: List<LastEventsLeague>, private val listener: (LastEventsLeague) -> Unit)
    : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(ListLeagueUI().createView(AnkoContext.create(p0.context, p0)))
    }

    override fun getItemCount(): Int = nextLeague.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItemsLastLeague(nextLeague[p1], listener)
    }

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvDateLeague: TextView = view.find(R.id.tvDateLeagueUI)
    private val tvHomeTeam: TextView = view.find(R.id.strHomeTeam)
    private val tvAwayTeam: TextView = view.find(R.id.strAwayTeam)
    private val tvHomeScore: TextView = view.find(R.id.score)

    fun bindItemsLastLeague(league: LastEventsLeague, listener: (LastEventsLeague) -> Unit) {
        tvDateLeague.text = league.dateEvent ?: ""
        tvHomeTeam.text = league.homeTeam ?: ""
        tvAwayTeam.text = league.awayTeam ?: ""

        val homeScore = league.homeScore ?: 0
        val awayScore = league.awayScore ?: 0
        tvHomeScore.text = " ${homeScore} VS ${awayScore} "
        itemView.setOnClickListener {
            listener(league)
        }
    }

    fun bindItemsNextLeague(league: NextEventsLeague, listener: (NextEventsLeague) -> Unit) {
        tvDateLeague.text = league.dateEvent ?: ""
        tvHomeTeam.text = league.homeTeam ?: ""
        tvAwayTeam.text = league.awayTeam ?: ""

        tvHomeScore.text = " ${league.homeScore?.toString()?: " "} VS ${league.awayScore?.toString()?: " "} "
        itemView.setOnClickListener {
            listener(league)
        }
    }
}