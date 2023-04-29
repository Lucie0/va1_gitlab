package cz.mendelu.pef.cv1.ui.screens.map

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState
import cz.mendelu.pef.cv1.navigation.INavigationRouter
import cz.mendelu.pef.cv1.ui.elements.BackArrowScreen
import org.koin.androidx.compose.getViewModel

@Composable
fun MapScreen(navigation: INavigationRouter,
              viewModel: MapViewModel = getViewModel(),
              latitude: Double?,    // poprve je null
              longitude: Double?
){
    BackArrowScreen(
        appBarTitle = "Map Screen",
        drawFullScreenContent = true,
        onBackClick = {
            // Todo navigace zpet
        }) {
        MapScreenContent(it)
    }
}

@Composable
fun MapScreenContent(paddingValues: PaddingValues){

    val mapUiSettings by remember { mutableStateOf(
        MapUiSettings(
            zoomControlsEnabled = false,
            mapToolbarEnabled = false)
    ) }

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(
            LatLng(
            49.21024872558183, 16.615863724525095), 10f) // souradnice z googlemaps -- prave mysitko
        // potreba klic do mapy -- vpravo lista gradle -- vlevo slonik execute -- SigningReport -- SHA1 klic (pro kazdou instalaci android studia)
        //D2:20:65:3E:C0:18:D0:C9:62:F0:25:6F:B6:8B:0A:85:42:14:A1:4F pro evo09

    }

    Box(modifier = Modifier.fillMaxSize().padding(paddingValues)){
        GoogleMap(modifier = Modifier.fillMaxSize(),
            uiSettings = mapUiSettings, // aby si kamera udrzela stavy
            cameraPositionState = cameraPositionState){

        }
    }
}