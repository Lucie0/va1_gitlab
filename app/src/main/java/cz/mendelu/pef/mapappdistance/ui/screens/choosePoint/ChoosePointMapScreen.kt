package cz.mendelu.pef.mapappdistance.ui.screens.choosePoint

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.*
import cz.mendelu.pef.mapappdistance.navigation.INavigationRouter
import cz.mendelu.pef.mapappdistance.ui.elements.BackArrowScreen
import org.koin.androidx.compose.getViewModel

@Composable
fun ChoosePointMapScreen(
    navigation: INavigationRouter,
    viewModel: ChoosePointMapViewModel = getViewModel()
) {
    var data: ChoosePointMapData by remember {
        mutableStateOf(viewModel.data)
    }

    viewModel.choosePointMapUiState.value.let {
        when (it) {
            ChoosePointMapUIState.Default -> {

            }
            is ChoosePointMapUIState.LocationChanged -> {
                data = viewModel.data
                viewModel.choosePointMapUiState.value = ChoosePointMapUIState.Default
            }
        }
    }

    BackArrowScreen(
        backArrowIcon = false,
        appBarTitle = "Map",
        onBackClick = { navigation.navigateBack() },
        drawFullScreenContent = true
    ) {

        ChoosePointMapScreenContent(
            paddingValues = it,
            latitude = 49.21024872558183,
            longitude = 16.615863724525095,
            actions = viewModel,
            onClick = {
                println("data.locationStart: " + data.locationStart)
                navigation.navigateToShowDistanceScreen(
                    data.locationStart!!.latitude,
                    data.locationStart!!.longitude,
                    data.locationEnd!!.latitude,
                    data.locationEnd!!.longitude
                )
            })
    }
}

@OptIn(MapsComposeExperimentalApi::class)
@Composable
fun ChoosePointMapScreenContent(
    paddingValues: PaddingValues,
    latitude: Double,
    longitude: Double,
    actions: ChoosePointMapActions,
    onClick: () -> Unit
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
            onMapClick = {
                actions.addLocation(it)
            },
            uiSettings = mapUiSettings, // aby si kamera udrzela stavy
            cameraPositionState = cameraPositionState
        ) {

            MapEffect { map ->
                map.setOnMarkerDragListener(object : GoogleMap.OnMarkerDragListener {
                    override fun onMarkerDrag(p0: Marker) {

                    }

                    override fun onMarkerDragEnd(p0: Marker) {
                        // updateLocation()
                        println(p0.id + ":" + p0.position.latitude + "\n" + p0.position.longitude)

                        if (p0.id == "m0") {
                            actions.onStartLocationChanged(
                                p0.position.latitude,
                                p0.position.longitude
                            )
                        } else if (p0.id == "m1") {
                            actions.onEndLocationChanged(
                                p0.position.latitude,
                                p0.position.longitude
                            )
                        }
                    }

                    override fun onMarkerDragStart(p0: Marker) {
                        println(p0.id)
                    }
                })
            }

            // posun markeru -- podrzet ho, pak se chytne do mysi


            // start point marker
            if (actions.startLocationNotNull()) {
                Marker(
                    state = MarkerState(actions.getStartLocation()!!),
                    draggable = true
                )
            }

            // end point marker
            if (actions.endLocationNotNull()) {
                Marker(
                    state = MarkerState(actions.getEndLocation()!!),
                    draggable = true
                )
            }
        }

        // karticka s pokyny
        OutlinedCard(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(16.dp)
                .size(
                    width = 270.dp,
                    height = 80.dp
                )

        ) {
            Text(text = "1. Tap to map to choose start point 2. Tap to map to choose end point 3. Drag point to change its position")

        }

        // POZN: pouze kvuli viditelnosti v mape
        Button(onClick = { }, modifier = Modifier.align(Alignment.BottomCenter)) {
            Text(text = "Show distance between points")
        }

        // potvrzovaci tlacitko pro zobrazeni vzdalenosti bodu
        ElevatedButton(
            modifier = Modifier.align(Alignment.BottomCenter),
            enabled = actions.bothLocationSetted(),
            onClick = onClick
        ) {
            Text("Show distance between points")
        }
    }

//    fun addLocation(newlocation: LatLng){
//        val queue: Queue<LatLng> = LinkedList(locations)
//
////        queue.poll() // vyber prvni a zahozeni
////        queue.add(newlocation)
////        queue.add(newlocation)
////        queue.add(newlocation)
//
//        locations = queue.toMutableList()
//    }
}

