package com.codingwithmitch.player

data class Player(
    val soloCompetitiveRank: Int? = null,
    val profile: Profile,
    val leaderBoardRank: Int? = null,
    val competitiveRank: Int? = null,
    val mmrEstimate: Int? = null,
)