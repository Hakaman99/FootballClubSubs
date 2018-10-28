package com.example.root.submission3.UI

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.example.root.submission3.R
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class RecyclerViewTeamUI : AnkoComponent<Context> {
    override fun createView(ui: AnkoContext<Context>) = with(ui) {
        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            topPadding = dip(16)
            leftPadding = dip(16)
            rightPadding = dip(16)
            swipeRefreshLayout {
                id = R.id.swipe_refresh_layout_team
                setColorSchemeResources(R.color.colorAccent,
                        android.R.color.holo_green_light,
                        android.R.color.holo_orange_light,
                        android.R.color.holo_red_light)

                relativeLayout {
                    lparams(width = matchParent, height = wrapContent)

                    recyclerView {
                        id = R.id.recycler_view_team
                        lparams(width = matchParent, height = wrapContent)
                        layoutManager = LinearLayoutManager(ctx)
                    }
                    progressBar {
                        id = R.id.progress_bar_rc_team
                    }.lparams {
                        centerHorizontally()
                    }
                }
            }

        }
    }

}