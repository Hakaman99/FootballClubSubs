package com.example.root.submission2.View.Adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.root.submission2.Model.NextEventsLeague.NextEventsLeague
import com.example.root.submission2.View.Fragment.FragmentUI.ListLeagueUI
import org.jetbrains.anko.AnkoContext

class NextLeagueAdapter(private val nextLeague:List<NextEventsLeague>, private val listener:(NextEventsLeague)->Unit)
    : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(ListLeagueUI().createView(AnkoContext.create(p0.context,p0)))
    }

    override fun getItemCount(): Int =nextLeague.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItemsNextLeague(nextLeague[p1],listener)
    }
}