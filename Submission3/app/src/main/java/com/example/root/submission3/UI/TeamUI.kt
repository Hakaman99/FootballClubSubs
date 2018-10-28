package com.example.root.submission3.UI

import android.graphics.Color
import android.view.ViewGroup
import com.example.root.submission3.R
import org.jetbrains.anko.*

class TeamUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        relativeLayout {
            lparams(width = matchParent, height = wrapContent)
            padding = dip(10)
            textView {
                id = R.id.tvDateLeagueUI
                textResource = R.string.Lorem
                textSize = 16f
            }.lparams {
                centerHorizontally()
            }
            textView {
                id = R.id.strHomeTeam
                textResource = R.string.Lorem
                textSize = 16f
            }.lparams {
                alignParentLeft()
                below(R.id.tvDateLeagueUI)
            }
            textView {
                id = R.id.score
                textResource = R.string.Lorem
                textSize = 16f
                textColor = Color.RED
            }.lparams {
                centerHorizontally()
                below(R.id.tvDateLeagueUI)
            }
            textView {
                id = R.id.strAwayTeam
                textResource = R.string.Lorem
                textSize = 16f
            }.lparams {
                alignParentRight()
                below(R.id.tvDateLeagueUI)
            }
        }
    }
}