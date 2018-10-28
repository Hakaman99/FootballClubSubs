package com.example.root.submission3

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.root.submission3.DB.database
import com.example.root.submission3.Event.LookUpEventPresenter
import com.example.root.submission3.Model.FavoriteTeams.Favorite
import com.example.root.submission3.Model.LookUpEvent.LookUpEvent
import com.example.root.submission3.Model.LookUpTeam.LookUpTeam
import com.example.root.submission3.Network.ApiRepository
import com.example.root.submission3.UI.DetailUI
import com.example.root.submission3.Utils.Constant
import com.example.root.submission3.Utils.invisible
import com.example.root.submission3.Utils.visible
import com.example.root.submission3.View.LookUpEventView
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast

class DetailActivity : AppCompatActivity(), LookUpEventView {
    private var isFavorite: Boolean = false
    private lateinit var idEvent: String
    private var teams: MutableList<LookUpEvent> = mutableListOf()
    private var menuItem: Menu? = null

    private lateinit var progresBar: ProgressBar
    private lateinit var presenter: LookUpEventPresenter
    private lateinit var dateEventsDetail: TextView
    private lateinit var imageHomeTeam: ImageView
    private lateinit var imageAwayTeam: ImageView
    private lateinit var nameHomeTeam: TextView
    private lateinit var nameAwayTeam: TextView
    private lateinit var scoreFootBall: TextView
    private lateinit var homeGoalDetail: TextView
    private lateinit var awayGoalDetail: TextView
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
        DetailUI().setContentView(this)
        supportActionBar?.title = resources.getString(R.string.titleBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        progresBar = find(R.id.progress_bar_detail)

        val intent = intent
        idEvent = intent.getStringExtra(Constant.TAG_DETAIL)

        favoriteState()
        val gson = Gson()
        val request = ApiRepository()
        presenter = LookUpEventPresenter(this, request, gson)
        presenter.getLookUpEvent(idEvent)

    }

    private fun favoriteState() {
        database.use {
            val result = select(Favorite.TABLE_FAVORITE)
                    .whereArgs("(${Favorite.ID_EVENT} = {id})",
                            "id" to idEvent)
            val favorite = result.parseList(classParser<Favorite>())
            if (!favorite.isEmpty()) isFavorite = true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        menuItem = menu
        setFavorite()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.add_to_favorite -> {
                if (isFavorite) removeFromFavorite() else addtoFavorite()
                isFavorite = !isFavorite
                setFavorite()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setFavorite() {
        if (isFavorite)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_added_to_favorite)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_add_to_favorite)
    }

    private fun addtoFavorite() {
        try {
            database.use {
                insert(Favorite.TABLE_FAVORITE,
                        Favorite.ID_EVENT to idEvent,
                        Favorite.DATE_EVENT to teams[0].dateEvent,
                        Favorite.HOME_SCORE to teams[0].homeScore,
                        Favorite.AWAY_SCORE to teams[0].awayScore,
                        Favorite.HOME_TEAM to teams[0].homeTeam,
                        Favorite.AWAY_TEAM to teams[0].awayTeam)
            }
            toast("Added to Favorite")
        } catch (e: SQLiteConstraintException) {
            toast(e.localizedMessage)
        }
    }

    private fun removeFromFavorite() {
        try {
            database.use {
                delete(Favorite.TABLE_FAVORITE, "(${Favorite.ID_EVENT} = {${Favorite.ID_DB}})",
                        "${Favorite.ID_DB}" to idEvent)

            }
            toast("Removed to Favorite")
        } catch (e: SQLiteConstraintException) {
            toast(e.localizedMessage)
        }
    }

    private fun lineUpSubstitutes(homeLineupSubs: String? = null, awayLineupSubs: String? = null) {
        homeLineupSubstitutes = find(R.id.home_lineup_substitutes)
        awayLineupSubstitutes = find(R.id.away_lineup_substitutes)

        homeLineupSubstitutes.text = homeLineupSubs
        awayLineupSubstitutes.text = awayLineupSubs
    }

    private fun lineUpForward(homeLineUpForward: String? = null, awaylineUpForward: String? = null) {
        homeLineupForward = find(R.id.home_lineup_forward)
        awayLineupForward = find(R.id.away_lineup_forward)

        homeLineupForward.text = homeLineUpForward
        awayLineupForward.text = awaylineUpForward
    }

    private fun lineUpMidfield(HomeMidfield: String? = null, awayMidfield: String? = null) {
        homeLineupMidfield = find(R.id.home_line_up_midfield)
        awayLineupMidfield = find(R.id.away_lineup_midfield)

        homeLineupMidfield.text = HomeMidfield
        awayLineupMidfield.text = awayMidfield
    }

    private fun lineupDefense(homeDefense: String? = null, awayDefense: String? = null) {
        homeLineupDefense = find(R.id.home_line_up_defense)
        awayLineupDefense = find(R.id.away_line_up_defense)

        homeLineupDefense.text = homeDefense
        awayLineupDefense.text = awayDefense

    }

    private fun lineUpGoalKeeper(homeGoalKeeper: String? = null, awayGoalKeeper: String? = null) {
        homeLineupGoalkeeper = find(R.id.home_line_up_goal_keeper)
        awayLineupGoalkeeper = find(R.id.away_line_up_goal_keeper)

        homeLineupGoalkeeper.text = homeGoalKeeper
        awayLineupGoalkeeper.text = awayGoalKeeper
    }

    private fun shoots(homeShot: Int? = null, awayShot: Int? = null) {
        homeShots = find(R.id.home_shots_detail)
        awayShots = find(R.id.away_shots_detail)

        homeShots.text = homeShot?.toString() ?: ""
        awayShots.text = awayShot?.toString() ?: ""
    }

    private fun goalDetail(homeGoal: String? = null, awayGoal: String? = null) {
        homeGoalDetail = find(R.id.home_goal_details)
        awayGoalDetail = find(R.id.away_goal_details)

        homeGoalDetail.text = homeGoal ?: ""
        awayGoalDetail.text = awayGoal ?: ""
    }

    private fun scoreAndDate(date: String? = null, scoreHome: Int? = null, scoreAway: Int? = null) {
        dateEventsDetail = find(R.id.date_events_detail)
        scoreFootBall = find(R.id.score_detail)

        dateEventsDetail.text = date ?: ""
        scoreFootBall.text = "${scoreHome?.toString() ?: ""} VS ${scoreAway?.toString() ?: ""}"
    }

    private fun nameTeam(nameHomeTeam: String? = null, nameAwayTeam: String? = null) {
        this.nameHomeTeam = find(R.id.tv_image_home_detail)
        this.nameAwayTeam = find(R.id.tv_image_away_detail)

        this.nameHomeTeam.text = nameHomeTeam ?: ""
        this.nameAwayTeam.text = nameAwayTeam ?: ""
    }

    private fun image(imgHome: String? = null, imgAway: String? = null) {
        imageHomeTeam = find(R.id.image_home_detail)
        imageAwayTeam = find(R.id.image_away_detail)
        Picasso.get().load(imgHome).into(imageHomeTeam)
        Picasso.get().load(imgAway).into(imageAwayTeam)

    }

    override fun showLoading() {
        progresBar.visible()
    }

    override fun hideLoading() {
        progresBar.invisible()
    }

    override fun getLookUpEventList(data: List<LookUpEvent>) {
        teams.clear()
        teams.addAll(data)
        scoreAndDate(data[0].dateEvent, data[0].homeScore, data[0].awayScore)
        nameTeam(data[0].homeTeam, data[0].awayTeam)
        goalDetail(data[0].homeGoalDetails, data[0].awayGoalDetails)
        shoots(data[0].homeShots, data[0].awayShots)
        lineUpGoalKeeper(data[0].homeLineupGoalkeeper, data[0].awayLineupGoalkeeper)
        lineupDefense(data[0].homeLineupDefense, data[0].awayLineupDefense)
        lineUpMidfield(data[0].homeLineupMidfield, data[0].awayLineupMidfield)
        lineUpForward(data[0].homeLineupForward, data[0].awayLineupForward)
        lineUpSubstitutes(data[0].homeLineupSubstitutes, data[0].awayLineupSubstitutes)


        presenter.getLookUpTeam(data[0].idhomeTeam.toString(), data[0].idAwayTeam.toString())
    }

    override fun geLookUpTeamList(dataHome: List<LookUpTeam>, dataAway: List<LookUpTeam>) {
        image(dataHome[0].teamBadge, dataAway[0].teamBadge)
    }
}