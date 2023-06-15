package cz.mendelu.pef.dostihyasazky.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true) // anotace na to, ze budeme tvorit json
data class Location(
    @Json(name = "latitude")
    var latitude: Double,
    @Json(name = "longitude")
    var longitude: Double)
