package cz.mendelu.pef.dostihyasazky.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.dostihyasazky.model.Game
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter
import cz.mendelu.pef.dostihyasazky.ui.elements.BackArrowScreen

@Composable
fun SavedGamesListScreen(navigation: INavigationRouter) {

    var savedGames = remember { mutableStateListOf<Game>() }

    savedGames.add(Game("10/10/2010", "hrac1"))
    savedGames.add(Game("06/12/2018", "hrac2"))

    BackArrowScreen(
        appBarTitle = "Seznam uložených her", // todo extract string
        onBackClick = { navigation.navigateBack() }
    ) {
        SavedGameListScreenContent(
            savedGames = savedGames,
            navigation = navigation
        )

    }

}

@Composable
fun SavedGameListScreenContent(
    savedGames: List<Game>,
    navigation: INavigationRouter

) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        savedGames.forEach {
            Column(
                modifier = Modifier.clickable {
                    navigation.navigateToGameScreen()
                    /* todo navigate to load this game */
                }
            ) {
                Text(it.date)
                Text(it.player)
                Divider()
            }
        }
    }

}