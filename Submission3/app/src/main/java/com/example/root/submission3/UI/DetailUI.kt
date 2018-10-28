package com.example.root.submission3.UI

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.example.root.submission3.R
import org.jetbrains.anko.*

class DetailUI : AnkoComponent<Context> {
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun createView(ui: AnkoContext<Context>) = with(ui) {
        scrollView {
            relativeLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(10)
                //PROGRESS BAR
                progressBar {
                    id = R.id.progress_bar_detail
                }.lparams {
                    centerInParent()
                }
                // DATE EVENTS
                textView {
                    id = R.id.date_events_detail
                    textResource = R.string.Lorem
                    textSize = 16f
                }.lparams {
                    centerHorizontally()
                    bottomMargin = dip(10)
                }

                //SCORE FOOTBALL
                linearLayout {
                    id = R.id.ll_score_detail
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL
                    //HOME TEAMS
                    relativeLayout {
                        //IMAGE VIEW HOME TEAM
                        imageView {
                            id = R.id.image_home_detail
                            setImageResource(R.drawable.ic_launcher_background)
                        }.lparams(width = dip(50), height = dip(50)) {
                            centerHorizontally()
                        }
                        //TEXT VIEW HOME TEAM
                        textView {
                            id = R.id.tv_image_home_detail
                            textResource = R.string.Lorem
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }.lparams {
                            centerHorizontally()
                            below(R.id.image_home_detail)
                        }
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.START
                    }

                    //SCORE
                    textView {
                        id = R.id.score_detail
                        textResource = R.string.Lorem
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
                            id = R.id.image_away_detail
                            setImageResource(R.drawable.ic_launcher_background)
                        }.lparams(width = dip(50), height = dip(50)) {
                            centerHorizontally()
                        }
                        //TEXT VIEW AWAY TEAM
                        textView {
                            id = R.id.tv_image_away_detail
                            textResource = R.string.Lorem
                            textAlignment = View.TEXT_ALIGNMENT_CENTER
                        }.lparams {
                            centerHorizontally()
                            below(R.id.image_away_detail)
                        }
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.END
                    }

                }.lparams(width = matchParent, height = wrapContent) {
                    below(R.id.date_events_detail)
                }

                // LINE
                view {
                    id = R.id.view_line_goals
                    backgroundColor = Color.GRAY
                }.lparams(width = matchParent, height = dip(1)) {
                    below(R.id.ll_score_detail)
                    topMargin = dip(3)
                    bottomMargin = dip(5)
                }

                //GOALS
                linearLayout {
                    id = R.id.ll_goals_detail
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL

                    //GOALS HOME TEAM
                    textView {
                        id = R.id.home_goal_details
                        textResource = R.string.Lorem
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.START

                    }
                    textView {
                        textResource = R.string.goals_detail
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.CENTER_HORIZONTAL
                    }
                    //GOALS AWAY TEAM
                    textView {
                        id = R.id.away_goal_details
                        textResource = R.string.Lorem
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.END

                    }

                }.lparams(width = matchParent, height = wrapContent) {
                    below(R.id.view_line_goals)
                }

                //SHOOTS
                linearLayout {
                    id = R.id.ll_shots
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL
                    //SHOOT HOME TEAM
                    textView {
                        id = R.id.home_shots_detail
                        textResource = R.string.Lorem
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.START

                    }

                    textView {
                        textResource = R.string.shoots_detail
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.CENTER_HORIZONTAL
                    }
                    //SHOOT AWAY TEAM
                    textView {
                        id = R.id.away_shots_detail
                        textResource = R.string.Lorem
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.END

                    }

                }.lparams(width = matchParent, height = wrapContent) {
                    below(R.id.ll_goals_detail)
                }


                //LINE
                view {
                    id = R.id.view_line_up_goals
                    backgroundColor = Color.GRAY
                }.lparams(width = matchParent, height = dip(1)) {
                    below(R.id.ll_shots)
                    topMargin = dip(5)
                    bottomMargin = dip(10)
                }

                // ****** LINE UPS *******
                textView {
                    id = R.id.line_ups
                    textResource = R.string.line_up_detail
                    textColor = Color.BLACK
                }.lparams {
                    centerHorizontally()
                    below(R.id.view_line_up_goals)
                }

                // **** GOAL KEEPER ****
                linearLayout {
                    id = R.id.ll_goal_keeper
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL
                    //GOAL KEEPER HOME TEAM
                    textView {
                        id = R.id.home_line_up_goal_keeper
                        textResource = R.string.Lorem
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.START
                    }

                    textView {
                        textResource = R.string.goal_keeper
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.CENTER_HORIZONTAL
                    }
                    //GOAL KEEPER AWAY TEAM
                    textView {
                        id = R.id.away_line_up_goal_keeper
                        textResource = R.string.Lorem
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.END

                    }

                }.lparams(width = matchParent, height = wrapContent) {
                    below(R.id.line_ups)
                    bottomMargin = dip(10)
                }

                // ***** DEFENSE ****
                linearLayout {
                    id = R.id.ll_defense
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL
                    //DEFENSE HOME TEAM
                    textView {
                        id = R.id.home_line_up_defense
                        textResource = R.string.Lorem
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
                        id = R.id.away_line_up_defense
                        textResource = R.string.Lorem
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.END

                    }

                }.lparams(width = matchParent, height = wrapContent) {
                    below(R.id.ll_goal_keeper)
                    bottomMargin = dip(10)
                }

                // ***** MIDDFIELD ****
                linearLayout {
                    id = R.id.ll_midd_field
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL

                    //MIDDFIELD HOME TEAM
                    textView {
                        id = R.id.home_line_up_midfield
                        textResource = R.string.Lorem
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
                        id = R.id.away_lineup_midfield
                        textResource = R.string.Lorem
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.END

                    }

                }.lparams(width = matchParent, height = wrapContent) {
                    below(R.id.ll_defense)
                    bottomMargin = dip(10)
                }

                // ***** FORWARD ****
                linearLayout {
                    id = R.id.ll_forward
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL
                    //FORWARD HOME TEAM
                    textView {
                        id = R.id.home_lineup_forward
                        textResource = R.string.Lorem
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
                        id = R.id.away_lineup_forward
                        textResource = R.string.Lorem
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.END

                    }

                }.lparams(width = matchParent, height = wrapContent) {
                    below(R.id.ll_midd_field)
                    bottomMargin = dip(10)
                }

                // ***** SUBSTITUTES ****
                linearLayout {
                    id = R.id.ll_substitutes
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL
                    //SUBSTITUTES HOME TEAM
                    textView {
                        id = R.id.home_lineup_substitutes
                        textResource = R.string.Lorem
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
                        id = R.id.away_lineup_substitutes
                        textResource = R.string.Lorem
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                    }.lparams(width = dip(0), height = wrapContent) {
                        weight = 1f
                        this.gravity = Gravity.END

                    }

                }.lparams(width = matchParent, height = wrapContent) {
                    below(R.id.ll_forward)
                    bottomMargin = dip(10)
                }
            }
        }
    }

}