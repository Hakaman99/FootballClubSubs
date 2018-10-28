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
import com.example.root.submission2.Model.NextEventsLeague.NextEventsLeague
import com.example.root.submission2.Network.ApiRepository
import com.example.root.submission2.Presenter.NextMatchPresenter
import com.example.root.submission2.R
import com.example.root.submission2.Utils.TAG
import com.example.root.submission2.Utils.invisible
import com.example.root.submission2.Utils.visible
import com.example.root.submission2.View.Activity.DetailNextLeagueActivity
import com.example.root.submission2.View.Adapter.NextLeagueAdapter
import com.example.root.submission2.View.NextMatchView
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class FragmentNextMatchLeague:Fragment(),AnkoComponent<Context>,NextMatchView{
    private var listNextEventLeague:MutableList<NextEventsLeague> = mutableListOf()
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var rcNextEventLeague: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var presenter: NextMatchPresenter
    private lateinit var adapter: NextLeagueAdapter

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
                    rcNextEventLeague = recyclerView {
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
        presenter = NextMatchPresenter(this, request, gson)
        presenter.getNextEventsLeague("4328")
        adapter = NextLeagueAdapter(listNextEventLeague){
            startActivity<DetailNextLeagueActivity>(TAG to it)
        }
        rcNextEventLeague.adapter = adapter

        swipeRefresh.onRefresh {
            presenter.getNextEventsLeague("4328")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return createView(AnkoContext.create(ctx))
    }
    companion object {
        fun newInstance():FragmentNextMatchLeague= FragmentNextMatchLeague()
    }

    override fun showLoading() {
       progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun showNextMatchView(data: List<NextEventsLeague>) {
        swipeRefresh.isRefreshing = false
        listNextEventLeague.clear()
        listNextEventLeague.addAll(data)
        adapter.notifyDataSetChanged()
    }
}