package cz.mendelu.pef.dostihyasazky.ui.screens.saved_games_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.dostihyasazky.model.SavedGame
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter
import cz.mendelu.pef.dostihyasazky.ui.elements.BackArrowScreen
import org.koin.androidx.compose.getViewModel

@Composable
fun SavedGamesListScreen(
    navigation: INavigationRouter,
    viewModel: SavedGamesListVM = getViewModel()
) {

    var savedGames = remember { mutableStateListOf<SavedGame>() }

//    savedGames.add(SavedGame("10/10/2010", 1))
//    savedGames.add(SavedGame("06/12/2018", 2))

    viewModel.uiState.value.let {
        when(it){
            SavedGamesListUIState.Default -> {
                viewModel.loadSavedGames()
            }
            is SavedGamesListUIState.Success -> {
                savedGames.clear()
                it.items?.let { success -> savedGames.addAll(success) }
            }
        }
    }

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedGameListScreenContent(
    savedGames: List<SavedGame>,
    navigation: INavigationRouter
) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        savedGames.forEach {
            Column(
                modifier = Modifier.clickable {
                    navigation.navigateToSavedGameDetailScreen(it.id)
                    /* todo load this game */
                }
            ) {
                ListItem(
                    overlineText = { it.name?.let { it1 -> Text(it1) } },
                    headlineText = { Text(it.date) },
                    supportingText = {
                        Text("Hráč na řadě: " + it.playerOnTurnId.toString())
                    }
                )
                Divider()
            }
        }
    }

}