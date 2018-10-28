package com.example.root.submission3.Teams.TeamNextLeague

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.example.root.submission3.DetailActivity
import com.example.root.submission3.Model.TeamNextLeague.TeamNextLeague
import com.example.root.submission3.Network.ApiRepository
import com.example.root.submission3.R
import com.example.root.submission3.UI.RecyclerViewTeamUI
import com.example.root.submission3.Utils.Constant
import com.example.root.submission3.Utils.invisible
import com.example.root.submission3.Utils.visible
import com.example.root.submission3.View.TeamNextLeagueView
import com.google.gson.Gson
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.support.v4.find
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.startActivity

class TeamNextLeagueFragment : Fragment(), TeamNextLeagueView {
    private var teamNextMatch: MutableList<TeamNextLeague> = mutableListOf()
    private lateinit var presenter: TeamNextLeaguePresenter
    private lateinit var adapter: TeamsNextMatchLeagueAdapter

    private lateinit var listTeam: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        val request = ApiRepository()
        val gson = Gson()
        presenter = TeamNextLeaguePresenter(this, request, gson)
        presenter.getTeamsNextLeague(Constant.ID_NEXT_MATCH)

        adapter = TeamsNextMatchLeagueAdapter(teamNextMatch) {
            startActivity<DetailActivity>(Constant.TAG_DETAIL to it.idEvent)
        }
        listTeam.adapter = adapter

        swipeRefreshLayout.onRefresh {
            presenter.getTeamsNextLeague(Constant.ID_NEXT_MATCH)
        }
    }

    private fun init() {
        listTeam = find(R.id.recycler_view_team)
        progressBar = find(R.id.progress_bar_rc_team)
        swipeRefreshLayout = find(R.id.swipe_refresh_layout_team)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return RecyclerViewTeamUI().createView(AnkoContext.create(requireContext()))
    }

    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun getTeamNextLeagueList(data: List<TeamNextLeague>) {
        swipeRefreshLayout.isRefreshing = false
        teamNextMatch.clear()
        teamNextMatch.addAll(data)
        adapter.notifyDataSetChanged()
    }
}