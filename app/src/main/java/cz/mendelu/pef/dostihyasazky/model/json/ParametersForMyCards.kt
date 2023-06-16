package cz.mendelu.pef.dostihyasazky.model.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true) // anotace na to, ze budeme tvorit json
data class ParametersForMyCards(
    @Json(name = "gameId")
    var gameId: Long,
    @Json(name = "playerId")
    var playerId: Long
)