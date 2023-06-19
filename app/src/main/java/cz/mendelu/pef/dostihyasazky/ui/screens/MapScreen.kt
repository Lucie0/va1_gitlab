package cz.mendelu.pef.dostihyasazky.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.*
import cz.mendelu.pef.dostihyasazky.R
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter
import cz.mendelu.pef.dostihyasazky.ui.elements.BackArrowScreen

@Composable
fun MapScreen(
    navigation: INavigationRouter,
    latitude: Double,
    longitude: Double
) {

    BackArrowScreen(
        appBarTitle = stringResource(R.string.Map_stable_detail),
        onBackClick = { navigation.navigateBack() },
        drawFullScreenContent = true
    ) {
        MapScreenContent(paddingValues = it,
            latitude = latitude,
            longitude = longitude
     )

//        latitude = latitude ?: 49.21024872558183,
//        longitude = longitude ?: 16.615863724525095,
    }
}

@Composable
fun MapScreenContent(
    paddingValues: PaddingValues,
    latitude: Double,
    longitude: Double,
) {

    val mapUiSettings by remember {
        mutableStateOf(
            MapUiSettings(
                zoomControlsEnabled = false,
                mapToolbarEnabled = false
            )
        )
    }

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(
            LatLng(
                latitude,
                longitude
            ), 10f
        ) // souradnice z googlemaps -- prave mysitko
        // 49.21024872558183, 16.615863724525095
        // potreba klic do mapy -- vpravo lista gradle -- vlevo slonik execute -- SigningReport -- SHA1 klic (pro kazdou instalaci android studia)
        //D2:20:65:3E:C0:18:D0:C9:62:F0:25:6F:B6:8B:0A:85:42:14:A1:4F pro evo09

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            uiSettings = mapUiSettings, // aby si kamera udrzela stavy
            cameraPositionState = cameraPositionState
        ) {
//            MapEffect { map ->
//                map.setOnMarkerDragListener(object : GoogleMap.OnMarkerDragListener {
//                    override fun onMarkerDrag(p0: Marker) {
//                        //todo
//                    }
//
//                    override fun onMarkerDragEnd(p0: Marker) {
//                        //todo
//                        // ulozeni coords do VM
////                        actions.onLocationChanged(
////                            latitude = p0.position.latitude,
////                            longitude = p0.position.longitude
////                        )
//                    }
//
//                    override fun onMarkerDragStart(p0: Marker) {
//                        //todo
//                    }
//                })
//            }
            //    state: MarkerState = rememberMarkerState(),
            //    alpha: Float = 1.0f,
            //    anchor: Offset = Offset(0.5f, 1.0f), // ktery bod znaci to dane misto (dolni bod pointu, stred kolecka, ...)
            //    draggable: Boolean = false, // posouvatelne
            //    flat: Boolean = false,
            //    icon: BitmapDescriptor? = null, // iconka
            //    infoWindowAnchor: Offset = Offset(0.5f, 0.0f),
            //    tag: Any? = null, // ulozeni jakekoli informace k markeru
            // posun markeru -- podrzet ho, pak se chytne do mysi

            Marker(
                state = MarkerState(LatLng(latitude, longitude)),
                draggable = true
            )
        }
    }


}
