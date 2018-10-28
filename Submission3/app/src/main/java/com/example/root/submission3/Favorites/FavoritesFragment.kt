package com.example.root.submission3.Favorites

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.example.root.submission3.DB.database
import com.example.root.submission3.DetailActivity
import com.example.root.submission3.Model.FavoriteTeams.Favorite
import com.example.root.submission3.R
import com.example.root.submission3.UI.RecyclerViewTeamUI
import com.example.root.submission3.Utils.Constant
import com.example.root.submission3.Utils.invisible
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.find
import org.jetbrains.anko.support.v4.onRefresh

class FavoritesFragment : Fragment() {
    private var favorites: MutableList<Favorite> = mutableListOf()
    private lateinit var listEvents: RecyclerView
    private lateinit var adapter: FavoriteTeamsAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return RecyclerViewTeamUI().createView(AnkoContext.create(requireContext()))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        adapter = FavoriteTeamsAdapter(favorites) {
            requireActivity().startActivity<DetailActivity>(Constant.TAG_DETAIL to "${it.eventId}")
        }
        listEvents.adapter = adapter
        showFavorite()
        swipeRefreshLayout.onRefresh {
            favorites.clear()
            showFavorite()
        }
    }

    private fun init() {
        listEvents = find(R.id.recycler_view_team)
        progressBar = find(R.id.progress_bar_rc_team)
        swipeRefreshLayout = find(R.id.swipe_refresh_layout_team)
    }

    private fun showFavorite() {
        progressBar.invisible()
        context?.database?.use {
            swipeRefreshLayout.isRefreshing = false
            val result = select(Favorite.TABLE_FAVORITE)
            val favorite = result.parseList(classParser<Favorite>())

            favorites.addAll(favorite)
            adapter.notifyDataSetChanged()
        }
    }
}