package cz.mendelu.pef.mapappdistance.ui.screens.showDistance

import android.location.Location
import com.google.android.gms.maps.model.LatLng
import cz.mendelu.pef.mapappdistance.architecture.BaseViewModel

class ShowDistanceMapViewModel () : BaseViewModel(), ShowDistanceMapActions{

    private val points = mutableListOf<LatLng>()

    override fun addCoords(latitude: Double, longitude: Double) {
        points.add(LatLng(latitude, longitude))
    }

    override fun getStartLocation(): LatLng {
        return points.first()
    }

    override fun getEndLocation(): LatLng {
        return points.last()
    }

    override fun getDistance(): Float {
        val location1: Location = Location("loc1")
        location1.latitude = getStartLocation().latitude
        location1.longitude = getStartLocation().longitude

        val location2: Location = Location("loc2")
        location2.latitude = getEndLocation().latitude
        location2.longitude = getEndLocation().longitude

        return location1.distanceTo(location2)
    }

    override fun getPoints(): List<LatLng> {
        return points
    }

}