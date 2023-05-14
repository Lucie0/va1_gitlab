package cz.mendelu.pef.mapappdistance.ui.screens.showDistance

import com.google.android.gms.maps.model.LatLng

interface ShowDistanceMapActions {

    fun addCoords(latitude: Double, longitude: Double)
//    fun onLocationChanged(latitude: Double, longitude: Double)

    fun getStartLocation(): LatLng
    fun getEndLocation(): LatLng

    fun getDistance(): Float

    fun getPoints(): List<LatLng>
}