package com.example.root.submission3.Model.FavoriteTeams

data class Favorite(
        val id: Long?,
        val eventId: String?,
        val dateEvent: String?,
        val homeScore: String?,
        val awayScore: String?,
        val homeTeam: String?,
        val awayTeam: String?) {
    companion object {
        const val TABLE_FAVORITE: String = "TABLE_FAVORITE"
        const val ID: String = "ID_"
        const val ID_EVENT: String = "ID_EVENT"
        const val ID_DB: String = "id"
        const val DATE_EVENT = "DATE_EVENT"
        const val HOME_SCORE: String = "HOME_SCORE"
        const val AWAY_SCORE: String = "AWAY_SCORE"
        const val HOME_TEAM: String = "HOME_TEAM"
        const val AWAY_TEAM: String = "AWAY_TEAM"

    }
}