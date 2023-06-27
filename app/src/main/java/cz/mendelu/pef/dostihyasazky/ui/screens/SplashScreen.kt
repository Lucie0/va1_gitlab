package cz.mendelu.pef.dostihyasazky.ui.screens

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.dostihyasazky.R
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter
import cz.mendelu.pef.dostihyasazky.ui.screens.a_main.MainScreenContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreen(
    navigation: INavigationRouter
){

    Scaffold(
        topBar = {
            TopAppBar(
                title = {}
            )
        }) {
        SplashScreenContent(
            paddingValues = it,
            navigation = navigation,
        )

    }

}


@Composable
fun SplashScreenContent(
    navigation: INavigationRouter,
    paddingValues: PaddingValues
){

    Column(
        modifier = androidx.compose.ui.Modifier
            .padding(paddingValues)
            .padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.my_icon_foreground),
            contentDescription = null,
        )
    }

}