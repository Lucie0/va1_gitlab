package cz.mendelu.pef.dostihyasazky.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.dostihyasazky.R
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navigation: INavigationRouter
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("DOSTIHY A SÁZKY") },// todo extract string
            )
        }) {
        MainScreenContent(
            paddingValues = it,
            navigation = navigation
        )
    }
}

@Composable
fun MainScreenContent(
    paddingValues: PaddingValues,
    navigation: INavigationRouter
) {

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.plan_svetly_1b_vyrez),
            contentDescription = "planek",
        )

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { navigation.navigateToGameScreen() }) {
                Text("Nová hra")// todo extract string
            }

            Button(onClick = { navigation.navigateToSavedGamesScreen() }) {
                Text("Načíst rozehranou")// todo extract string
            }
        }
    }
}