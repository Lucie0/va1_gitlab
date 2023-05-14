package cz.mendelu.pef.mapappdistance.ui.screens.choosePoint

import com.google.android.gms.maps.model.LatLng

interface ChoosePointMapActions {
    fun onStartLocationChanged(latitude: Double, longitude: Double)
    fun onEndLocationChanged(latitude: Double, longitude: Double)
    fun bothLocationSetted(): Boolean
    fun addLocation(newlocation: LatLng)

    fun startLocationNotNull(): Boolean
    fun endLocationNotNull(): Boolean

    fun getStartLocation(): LatLng?
    fun getEndLocation(): LatLng?
}