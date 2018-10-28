package com.example.root.submission3.Teams.TeamLastLeague

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.SearchView
import com.example.root.submission3.DetailActivity
import com.example.root.submission3.Model.TeamLastLeague.TeamLastLeague
import com.example.root.submission3.Network.ApiRepository
import com.example.root.submission3.R
import com.example.root.submission3.UI.RecyclerViewTeamUI
import com.example.root.submission3.Utils.Constant
import com.example.root.submission3.Utils.invisible
import com.example.root.submission3.Utils.visible
import com.example.root.submission3.View.TeamLastLeagueView
import com.google.gson.Gson
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.support.v4.find
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.startActivity

class TeamsLastLeagueFragment : Fragment(), TeamLastLeagueView {
    private var teamsLastMatch: MutableList<TeamLastLeague> = mutableListOf()
    private lateinit var presenter: TeamLastLeaguePresenter
    private lateinit var adapter: TeamLastMatchLeagueAdapter

    private lateinit var listTeam: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        val request = ApiRepository()
        val gson = Gson()
        presenter = TeamLastLeaguePresenter(this, request, gson)
        presenter.getTeamLastLeague(Constant.ID_LAST_MATCH)

        adapter = TeamLastMatchLeagueAdapter(teamsLastMatch) {
            startActivity<DetailActivity>(Constant.TAG_DETAIL to it.idEvent)
        }
        listTeam.adapter = adapter

        swipeRefreshLayout.onRefresh {
            presenter.getTeamLastLeague(Constant.ID_LAST_MATCH)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search, menu)
        val searchItem = menu.findItem(R.id.menu_search)
        var searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchItemSelected(searchItem)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun searchItemSelected(searchItem: MenuItem) {
        if (searchItem != null) {
            val searchView = searchItem.actionView as SearchView
            val editText = searchView.findViewById<EditText>(android.support.v7.appcompat.R.id.search_src_text)
            editText.hint = "Search here ..."
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

    override fun getTeamLastLeagueList(data: List<TeamLastLeague>) {
        swipeRefreshLayout.isRefreshing = false
        teamsLastMatch.clear()
        teamsLastMatch.addAll(data)
        adapter.notifyDataSetChanged()
    }
}