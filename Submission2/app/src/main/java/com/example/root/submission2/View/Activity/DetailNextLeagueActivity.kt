package com.example.root.submission2.View.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.root.submission2.Model.NextEventsLeague.NextEventsLeague
import com.example.root.submission2.Model.LookUpTeam.LookUpTeam
import com.example.root.submission2.Network.ApiRepository
import com.example.root.submission2.Presenter.LookUpTeamPresenter
import com.example.root.submission2.R
import com.example.root.submission2.Utils.invisible
import com.example.root.submission2.Utils.visible
import com.example.root.submission2.View.LookUpTeamView
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class DetailNextLeagueActivity : AppCompatActivity(), LookUpTeamView {
    private lateinit var progresBar: ProgressBar
    private lateinit var presenter: LookUpTeamPresenter
    private lateinit var imageViewHomeTeam: ImageView
    private lateinit var imageViewAwayTeam: ImageView
    private lateinit var dateEvent: TextView
    private lateinit var nameTeamHome: TextView
    private lateinit var nameTeamAway: TextView
    private lateinit var scoreFootbal: TextView
    private lateinit var homeGoalDetails: TextView
    private lateinit var awayGoalDetails: TextView
    private lateinit var homeShots: TextView
    private lateinit var awayShots: TextView
    private lateinit var homeLineupGoalkeeper: TextView
    private lateinit var awayLineupGoalkeeper: TextView
    private lateinit var homeLineupDefense: TextView
    private lateinit var awayLineupDefense: TextView
    private lateinit var homeLineupMidfield: TextView
    private lateinit var awayLineupMidfield: TextView
    private lateinit var homeLineupForward: TextView
    private lateinit var awayLineupForward: TextView
    private lateinit var homeLineupSubstitutes: TextView
    private lateinit var awayLineupSubstitutes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailLeagueActivityUI().setContentView(this)
        val intent = intent
        val items = intent.getParcelableExtra<NextEventsLeague>("detail")
        progresBar = find(R.id.progressBar)

        initLookUpTeams(items)
        setDateandScoreEvent(items)
        setGoalDetail(items)
        setNameTeam(items)
        setShootsTeam(items)
        setGoalKeeperTeam(items)
        setDefenseTeam(items)
        setMidfieldTeam(items)
        setForwardTeam(items)
        setSubstitutes(items)

    }


    private fun initLookUpTeams(items: NextEventsLeague) {
        val request = ApiRepository()
        val gson = Gson()
        presenter = LookUpTeamPresenter(this, request, gson)
        presenter.getLookUpTeam(items.idhomeTeam, items.idAwayTeam)
    }

    override fun showLoading() {
        progresBar.visible()
    }

    override fun hideLoading() {
        progresBar.invisible()
    }

    override fun showLookUpTeam(dataHome: List<LookUpTeam>, dataAway: List<LookUpTeam>) {
        imageViewHomeTeam = find(R.id.imageHome)
        imageViewAwayTeam = find(R.id.imageAway)

        Picasso.get().load(dataHome.get(0).teamBadge).into(imageViewHomeTeam)
        Picasso.get().load(dataAway.get(0).teamBadge).into(imageViewAwayTeam)
    }


    private fun setGoalDetail(items: NextEventsLeague) {
        homeGoalDetails = find(R.id.homeGoalDetails)
        awayGoalDetails = find(R.id.awayGoalDetails)

        homeGoalDetails.text = items.homeGoalDetails ?: ""
        awayGoalDetails.text = items.awayGoalDetails ?: ""
    }

    private fun setDateandScoreEvent(items: NextEventsLeague) {
        dateEvent = find(R.id.detailDateEvents)
        scoreFootbal = find(R.id.detailScore)

        dateEvent.text = items.dateEvent ?: ""
        scoreFootbal.text = "${items.homeScore ?: ""} vs ${items.awayScore ?: ""}"
    }


    private fun setForwardTeam(items: NextEventsLeague) {
        homeLineupForward = find(R.id.homeLineupForward)
        awayLineupForward = find(R.id.awayLineupForward)

        homeLineupForward.text = items.homeLineupForward ?: ""
        awayLineupForward.text = items.awayLineupForward ?: ""
    }

    private fun setMidfieldTeam(items: NextEventsLeague) {
        homeLineupMidfield = find(R.id.homeLineupMidfield)
        awayLineupMidfield = find(R.id.awayLineupMidfield)

        homeLineupMidfield.text = items.homeLineupMidfield ?: ""
        awayLineupMidfield.text = items.awayLineupMidfield ?: ""
    }

    private fun setDefenseTeam(items: NextEventsLeague) {
        homeLineupDefense = find(R.id.homeLineupDefense)
        awayLineupDefense = find(R.id.awayLineupDefense)

        homeLineupDefense.text = items.homeLineupDefense ?: ""
        awayLineupDefense.text = items.awayLineupDefense ?: ""
    }

    private fun setGoalKeeperTeam(items: NextEventsLeague) {
        homeLineupGoalkeeper = find(R.id.homeLineupGoalkeeper)
        awayLineupGoalkeeper = find(R.id.awayLineupGoalkeeper)

        homeLineupGoalkeeper.text = items.homeLineupGoalkeeper ?: ""
        awayLineupGoalkeeper.text = items.awayLineupGoalkeeper ?: ""
    }

    private fun setShootsTeam(items: NextEventsLeague) {
        homeShots = find(R.id.homeShots)
        awayShots = find(R.id.awayShots)

        homeShots.text = items.homeShots?.toString() ?: " "
        awayShots.text = items.awayShots?.toString() ?: " "
    }

    private fun setNameTeam(items: NextEventsLeague) {
        nameTeamHome = find(R.id.captionImageHome)
        nameTeamAway = find(R.id.captionImageAway)

        nameTeamHome.text = items.homeTeam ?: ""
        nameTeamAway.text = items.awayTeam ?: ""
    }

    private fun setSubstitutes(items: NextEventsLeague) {
        homeLineupSubstitutes = find(R.id.homeLineupSubstitutes)
        awayLineupSubstitutes = find(R.id.awayLineupSubstitutes)

        homeLineupSubstitutes.text = items.homeLineupSubstitutes ?: ""
        awayLineupSubstitutes.text = items.awayLineupSubstitutes ?: ""
    }
}