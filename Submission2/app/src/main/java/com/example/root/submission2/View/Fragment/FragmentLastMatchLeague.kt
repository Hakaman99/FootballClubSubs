package com.example.root.submission2.View.Fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import com.example.root.submission2.Model.LastEventsLeague.LastEventsLeague
import com.example.root.submission2.Network.ApiRepository
import com.example.root.submission2.Presenter.LastMatchPresenter
import com.example.root.submission2.R
import com.example.root.submission2.Utils.TAG
import com.example.root.submission2.Utils.invisible
import com.example.root.submission2.Utils.visible
import com.example.root.submission2.View.Activity.DetailLastLeagueActivity
import com.example.root.submission2.View.Adapter.LastLeagueAdapter
import com.example.root.submission2.View.LastMatchView
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class FragmentLastMatchLeague : Fragment(), LastMatchView, AnkoLogger, AnkoComponent<Context> {

    private var listLastEventLeague: MutableList<LastEventsLeague> = mutableListOf()
    private lateinit var presenter: LastMatchPresenter
    private lateinit var adapter: LastLeagueAdapter
    private lateinit var rcLastEventLeague: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout

    override fun createView(ui: AnkoContext<Context>) = with(ui) {
        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            topPadding = dip(16)
            leftPadding = dip(16)
            rightPadding = dip(16)
            swipeRefresh = swipeRefreshLayout {
                setColorSchemeResources(R.color.colorAccent,
                        android.R.color.holo_green_light,
                        android.R.color.holo_orange_light,
                        android.R.color.holo_red_light)

                relativeLayout {
                    lparams(width = matchParent, height = wrapContent)
                    rcLastEventLeague = recyclerView {
                        lparams(width = matchParent, height = wrapContent)
                        layoutManager = LinearLayoutManager(ctx)
                    }
                    progressBar = progressBar {

                    }.lparams {
                        centerHorizontally()
                    }
                }
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val request = ApiRepository()
        val gson = Gson()
        presenter = LastMatchPresenter(this, request, gson)
        presenter.getLastEventsLeague("4328")
        adapter = LastLeagueAdapter(listLastEventLeague) {
            startActivity<DetailLastLeagueActivity>(TAG to it)
        }
        rcLastEventLeague.adapter = adapter

        swipeRefresh.onRefresh {
            presenter.getLastEventsLeague("4328")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return createView(AnkoContext.create(ctx))

    }

    companion object {
        fun newInstance(): FragmentLastMatchLeague = FragmentLastMatchLeague()
    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
    }


    override fun showLastLeagueList(data: List<LastEventsLeague>) {
        swipeRefresh.isRefreshing = false
        listLastEventLeague.clear()
        listLastEventLeague.addAll(data)
        adapter.notifyDataSetChanged()
    }

}