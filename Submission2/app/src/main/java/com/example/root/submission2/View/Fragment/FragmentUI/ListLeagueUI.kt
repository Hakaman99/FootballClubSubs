package com.example.root.submission2.View.Fragment.FragmentUI

import android.graphics.Color
import android.view.ViewGroup
import com.example.root.submission2.R
import org.jetbrains.anko.*

class ListLeagueUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        relativeLayout {
            lparams(width = matchParent, height = wrapContent)
            padding = dip(10)
            textView {
                id = R.id.tvDateLeagueUI
                textResource = R.string.dateEvents
                textSize = 16f
            }.lparams {
                centerHorizontally()
            }
            textView {
                id = R.id.strHomeTeam
                textResource=R.string.caption
                textSize = 16f
            }.lparams {
                alignParentLeft()
                below(R.id.tvDateLeagueUI)
            }
            textView {
                id = R.id.score
                textResource=R.string.score
                textSize = 16f
                textColor = Color.RED
            }.lparams {
                centerHorizontally()
                below(R.id.tvDateLeagueUI)
            }
            textView {
                id = R.id.strAwayTeam
                textResource=R.string.caption
                textSize = 16f
            }.lparams {
                alignParentRight()
                below(R.id.tvDateLeagueUI)
            }
        }

    }


}