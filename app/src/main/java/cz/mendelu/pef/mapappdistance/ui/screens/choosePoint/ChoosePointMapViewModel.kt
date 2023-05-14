package cz.mendelu.pef.mapappdistance.ui.screens.choosePoint

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.google.android.gms.maps.model.LatLng
import cz.mendelu.pef.mapappdistance.architecture.BaseViewModel

class ChoosePointMapViewModel()
    : BaseViewModel(), ChoosePointMapActions {
//    var latitudeStart: Double? = null
//    var longitudeStart: Double? = null
//    var latitudeEnd: Double? = null
//    var longitudeEnd: Double? = null
    var locationChanged = false


    var data: ChoosePointMapData = ChoosePointMapData()

    var locations: MutableList<LatLng> = mutableStateListOf()

    var choosePointMapUiState: MutableState<ChoosePointMapUIState> =
        mutableStateOf(ChoosePointMapUIState.Default)

// todo    var startPoint = true    k odliseni markeru?

    override fun onStartLocationChanged(latitude: Double, longitude: Double){
        locationChanged = true
        data.locationStart = LatLng(latitude, longitude)
    }

    override fun onEndLocationChanged(latitude: Double, longitude: Double) {
        locationChanged = true
        data.locationEnd = LatLng(latitude, longitude)
    }

    override fun bothLocationSetted(): Boolean {
        return data.locationStart != null && data.locationEnd != null
    }

    override fun addLocation(newlocation: LatLng) {
        if (data.locationStart == null) {
//            println("add location: 1")
            data.locationStart = newlocation
            choosePointMapUiState.value = ChoosePointMapUIState.LocationChanged
        } else if (data.locationEnd == null) {
//            println("add location: 2")

            data.locationEnd = newlocation
            choosePointMapUiState.value = ChoosePointMapUIState.LocationChanged
        } else {
//            println("add location: 3")

            // oba plny, tudiz nic nedelam
        }

    }

    override fun startLocationNotNull(): Boolean {
        return data.locationStart != null
    }

    override fun endLocationNotNull(): Boolean {
        return data.locationEnd != null
    }

    override fun getStartLocation(): LatLng? {
        return data.locationStart
    }

    override fun getEndLocation(): LatLng? {
        return data.locationEnd
    }

}