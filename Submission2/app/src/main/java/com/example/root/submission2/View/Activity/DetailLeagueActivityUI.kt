package com.example.root.submission2.View.Activity

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.example.root.submission2.R
import org.jetbrains.anko.*

class DetailLeagueActivityUI : AnkoComponent<Context> {
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun createView(ui: AnkoContext<Context>) = with(ui) {
        scrollView {
            relativeLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(10)
                //PROGRESS BAR
                progressBar {
                    id = R.id.progressBar
                }.lparams {
                    centerInParent()
                }
                // DATE EVENTS
                textView {
                    id = R.id.detailDateEvents
                    textResource = R.string.dateEvents
                    textSize = 16f
                }.lparams {
                    centerHorizontally()
                    bottomMargin = dip(10)
                }

                //SCORE FOOTBALL
                linearLayout {
                    id = R.id.llDetailScore
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL
                    //HOME TEAMS
                    relativeLayout {
                        //IMAGE VIEW HOME TEAM
                        imageView {
                            id = R.id.imageHome
                            setImageResource(R.drawable.ic_launcher_background)
                        }.lparams(width = dip(50), height = dip(50)) {
                            centerHorizontally()
                        }
                        //TEXT VIEW HOME TEAM
                        textView {
                            id = R.id.captionImageHome
                            textResource = R.string.caption
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }.lparams {
                            centerHorizontally()
                            below(R.id.imageHome)
                        }
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.START
                    }

                    //SCORE
                    textView {
                        id = R.id.detailScore
                        textResource = R.string.score
                        textSize = 30f
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.CENTER
                    }

                    //AWAY TEAMS
                    relativeLayout {
                        //IMAGE VIEW AWAY TEAM
                        imageView {
                            id = R.id.imageAway
                            setImageResource(R.drawable.ic_launcher_background)
                        }.lparams(width = dip(50), height = dip(50)) {
                            centerHorizontally()
                        }
                        //TEXT VIEW AWAY TEAM
                        textView {
                            id = R.id.captionImageAway
                            textResource = R.string.caption
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }.lparams {
                            centerHorizontally()
                            below(R.id.imageAway)
                        }
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.END
                    }

                }.lparams(width = matchParent, height = wrapContent) {
                    below(R.id.detailDateEvents)
                }

                // LINE
                view {
                    id = R.id.viewLineGoals
                    backgroundColor = Color.GRAY
                }.lparams(width = matchParent, height = dip(1)) {
                    below(R.id.llDetailScore)
                    topMargin = dip(3)
                    bottomMargin = dip(5)
                }

                //GOALS
                linearLayout {
                    id = R.id.llDetailGoals
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL

                    //GOALS HOME TEAM
                    textView {
                        id = R.id.homeGoalDetails
                        textResource = R.string.data
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.START

                    }
                    textView {
                        textResource = R.string.goals
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.CENTER_HORIZONTAL
                    }
                    //GOALS AWAY TEAM
                    textView {
                        id = R.id.awayGoalDetails
                        textResource = R.string.data
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.END

                    }

                }.lparams(width = matchParent, height = wrapContent) {
                    below(R.id.viewLineGoals)
                }

                //SHOOTS
                linearLayout {
                    id = R.id.llShots
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL
                    //SHOOT HOME TEAM
                    textView {
                        id = R.id.homeShots
                        textResource = R.string.shoot
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.START

                    }

                    textView {
                        textResource = R.string.shoots
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.CENTER_HORIZONTAL
                    }
                    //SHOOT AWAY TEAM
                    textView {
                        id = R.id.awayShots
                        textResource = R.string.shoot
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.END

                    }

                }.lparams(width = matchParent, height = wrapContent) {
                    below(R.id.llDetailGoals)
                }


                //LINE
                view {
                    id = R.id.viewLineUpGoals
                    backgroundColor = Color.GRAY
                }.lparams(width = matchParent, height = dip(1)) {
                    below(R.id.llShots)
                    topMargin = dip(5)
                    bottomMargin = dip(10)
                }

                // ****** LINE UPS *******
                textView {
                    id = R.id.lineUps
                    textResource = R.string.lineUps
                    textColor = Color.BLACK
                }.lparams {
                    centerHorizontally()
                    below(R.id.viewLineUpGoals)
                }

                // **** GOAL KEEPER ****
                linearLayout {
                    id = R.id.llGoalKeeper
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL
                    //GOAL KEEPER HOME TEAM
                    textView {
                        id = R.id.homeLineupGoalkeeper
                        textResource = R.string.data
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.START
                    }

                    textView {
                        textResource = R.string.goalKeeper
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.CENTER_HORIZONTAL
                    }
                    //GOAL KEEPER AWAY TEAM
                    textView {
                        id = R.id.awayLineupGoalkeeper
                        textResource = R.string.data
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.END

                    }

                }.lparams(width = matchParent, height = wrapContent) {
                    below(R.id.lineUps)
                    bottomMargin = dip(10)
                }

                // ***** DEFENSE ****
                linearLayout {
                    id = R.id.llDefense
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL
                    //DEFENSE HOME TEAM
                    textView {
                        id = R.id.homeLineupDefense
                        textResource = R.string.data
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.START
                    }

                    textView {
                        textResource = R.string.defense
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.CENTER_HORIZONTAL
                    }
                    //DEFENSE AWAY TEAM
                    textView {
                        id = R.id.awayLineupDefense
                        textResource = R.string.data
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.END

                    }

                }.lparams(width = matchParent, height = wrapContent) {
                    below(R.id.llGoalKeeper)
                    bottomMargin = dip(10)
                }

                // ***** MIDDFIELD ****
                linearLayout {
                    id = R.id.llMiddField
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL

                    //MIDDFIELD HOME TEAM
                    textView {
                        id = R.id.homeLineupMidfield
                        textResource = R.string.data
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.START
                    }

                    textView {
                        textResource = R.string.midfield
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.CENTER_HORIZONTAL
                    }
                    //MIDDFIELD AWAY TEAM
                    textView {
                        id = R.id.awayLineupMidfield
                        textResource = R.string.data
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.END

                    }

                }.lparams(width = matchParent, height = wrapContent) {
                    below(R.id.llDefense)
                    bottomMargin = dip(10)
                }

                // ***** FORWARD ****
                linearLayout {
                    id = R.id.llForward
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL
                    //FORWARD HOME TEAM
                    textView {
                        id = R.id.homeLineupForward
                        textResource = R.string.data
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.START
                    }

                    textView {
                        textResource = R.string.forward
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.CENTER_HORIZONTAL
                    }

                    //FORWARD AWAY TEAM
                    textView {
                        id = R.id.awayLineupForward
                        textResource = R.string.data
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.END

                    }

                }.lparams(width = matchParent, height = wrapContent) {
                    below(R.id.llMiddField)
                    bottomMargin = dip(10)
                }

                // ***** SUBSTITUTES ****
                linearLayout {
                    id = R.id.llSubstitutes
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL
                    //SUBSTITUTES HOME TEAM
                    textView {
                        id=R.id.homeLineupSubstitutes
                        textResource = R.string.data
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.START
                    }

                    textView {
                        textResource = R.string.substitutes
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.CENTER_HORIZONTAL
                    }
                    //SUBSTITUTES AWAY TEAM
                    textView {
                        id=R.id.awayLineupSubstitutes
                        textResource = R.string.data
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.END

                    }

                }.lparams(width = matchParent, height = wrapContent) {
                    below(R.id.llForward)
                    bottomMargin = dip(10)
                }
            }
        }
    }
}