package cz.mendelu.pef.mapappdistance.ui.screens.showDistance

import android.widget.TextView
import androidx.compose.foundation.layout.*
import android.location.Location as Loc
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import cz.mendelu.pef.mapappdistance.di.viewModelModule
import cz.mendelu.pef.mapappdistance.navigation.INavigationRouter
import cz.mendelu.pef.mapappdistance.ui.elements.BackArrowScreen
import org.koin.androidx.compose.getViewModel

@Composable
fun ShowDistanceMapScreen(
    navigation: INavigationRouter,
    latitude1: Double,
    longitude1: Double,
    latitude2: Double,
    longitude2: Double,
    viewModel: ShowDistanceMapViewModel = getViewModel()
) {

    viewModel.addCoords(latitude1, longitude1)
    viewModel.addCoords(latitude2, longitude2)

    var distance: Float = viewModel.getDistance()

    BackArrowScreen(
        appBarTitle = "Show distance",
        drawFullScreenContent = true,
        onBackClick = { navigation.navigateBack() }) {
        ShowDistanceMapScreenContent(
            paddingValues = it,
            actions = viewModel,
            distance = distance
        )
    }
}


@Composable
fun ShowDistanceMapScreenContent(
    paddingValues: PaddingValues,
    actions: ShowDistanceMapActions,
    distance: Float
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
                (actions.getStartLocation().latitude + actions.getEndLocation().latitude) / 2,
                (actions.getStartLocation().longitude + actions.getEndLocation().longitude) / 2
            ), 10f
        ) // souradnice z googlemaps -- prave mysitko
        // 49.21024872558183, 16.615863724525095
        // potreba klic do mapy -- vpravo lista gradle -- vlevo slonik execute -- SigningReport -- SHA1 klic (pro kazdou instalaci android studia)
        //D2:20:65:3E:C0:18:D0:C9:62:F0:25:6F:B6:8B:0A:85:42:14:A1:4F pro evo09

    }

    val text: String = "Distance \n$distance meters"

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
            Circle(
                center = actions.getStartLocation(),
                radius = 250.0,
                fillColor = Color.Blue,
                strokeColor = Color.Blue
            )
            Circle(
                center = actions.getEndLocation(),
                radius = 250.0,
                fillColor = Color.Blue,
                strokeColor = Color.Blue
            )
            Polyline(
                points = actions.getPoints(),
                color = Color.Blue
            )
        }

        Column(
            Modifier
                .width(180.dp)
                .height(80.dp)
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = { context ->
                    TextView(context).apply {
                        setText(text)
                        setTextColor((Color.Black).toArgb())
                        setBackgroundColor(Color.White.toArgb())
                        setPadding(0, 0, 0, 32)
                    }
                })
        }
    }
}