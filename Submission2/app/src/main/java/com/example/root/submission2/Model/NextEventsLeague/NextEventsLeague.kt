package com.example.root.submission2.Model.NextEventsLeague

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NextEventsLeague(
        @SerializedName("idEvent")
        val idEvent:String?,
        @SerializedName("dateEvent")
        val dateEvent:String?,
        @SerializedName("strHomeTeam")
        val homeTeam:String?,
        @SerializedName("strAwayTeam")
        val awayTeam:String?,
        @SerializedName("intHomeScore")
        val homeScore:Int?,
        @SerializedName("intAwayScore")
        val awayScore:Int?,
        @SerializedName("strHomeGoalDetails")
        val homeGoalDetails:String?,
        @SerializedName("strAwayGoalDetails")
        val awayGoalDetails:String?,
        @SerializedName("intHomeShots")
        val homeShots:Int?,
        @SerializedName("intAwayShots")
        val awayShots:Int?,
        @SerializedName("strHomeLineupGoalkeeper")
        val homeLineupGoalkeeper:String?,
        @SerializedName("strAwayLineupGoalkeeper")
        val awayLineupGoalkeeper:String?,
        @SerializedName("strHomeLineupDefense")
        val homeLineupDefense:String?,
        @SerializedName("strAwayLineupDefense")
        val awayLineupDefense:String?,
        @SerializedName("strHomeLineupMidfield")
        val homeLineupMidfield:String?,
        @SerializedName("strAwayLineupMidfield")
        val awayLineupMidfield:String?,
        @SerializedName("strHomeLineupForward")
        val homeLineupForward:String?,
        @SerializedName("strAwayLineupForward")
        val awayLineupForward:String?,
        @SerializedName("strHomeLineupSubstitutes")
        val homeLineupSubstitutes:String?,
        @SerializedName("strAwayLineupSubstitutes")
        val awayLineupSubstitutes:String?,
        @SerializedName("idHomeTeam")
        val idhomeTeam:String?,
        @SerializedName("idAwayTeam")
        val idAwayTeam:String?
):Parcelable
