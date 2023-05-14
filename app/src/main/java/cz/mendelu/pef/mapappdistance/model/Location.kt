package cz.mendelu.pef.mapappdistance.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true) // anotace na to, ze budeme tvorit json
data class Location(
    @Json(name = "latitude1")
    var latitude1: Double,
    @Json(name = "longitude1")
    var longitude1: Double,
    @Json(name = "latitude2")
    var latitude2: Double,
    @Json(name = "longitude2")
    var longitude2: Double
)



