package com.example.root.submission3.Model.TeamNextLeague

import com.google.gson.annotations.SerializedName

data class TeamNextLeague(
        @SerializedName("idEvent")
        val idEvent: String? = null,
        @SerializedName("dateEvent")
        val dateEvent: String? = null,
        @SerializedName("strHomeTeam")
        val homeTeam: String? = null,
        @SerializedName("strAwayTeam")
        val awayTeam: String? = null,
        @SerializedName("intHomeScore")
        val homeScore: Int? = null,
        @SerializedName("intAwayScore")
        val awayScore: Int? = null
)