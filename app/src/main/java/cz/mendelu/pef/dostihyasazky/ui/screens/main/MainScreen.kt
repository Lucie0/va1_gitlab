package cz.mendelu.pef.dostihyasazky.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navigation: INavigationRouter
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dostihy a sazky") }// todo extract string
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

    // todo image of game plan
//    Image(
//        painter = painterResource(id = R.drawable.game_plan_background),
//        contentDescription = null)


    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(horizontal = 16.dp)
    ) {
        Button(onClick = { navigation.navigateToGameScreen() }) {
            Text("Nová hra")// todo extract string
        }

        Button(onClick = { navigation.navigateToSavedGamesScreen() }) {
            Text("Načíst rozehranou")// todo extract string
        }
    }


}