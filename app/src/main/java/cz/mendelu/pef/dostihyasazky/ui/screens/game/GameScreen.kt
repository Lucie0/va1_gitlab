package cz.mendelu.pef.dostihyasazky.ui.screens.game

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.dostihyasazky.R
import cz.mendelu.pef.dostihyasazky.model.SavedGame
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter
import cz.mendelu.pef.dostihyasazky.ui.elements.BackArrowScreen
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(
    navigation: INavigationRouter,
    savedGameId: Long?,
    viewModel: GameScreenVM = getViewModel()
) {

    viewModel.loadGameId = savedGameId ?: -1L

    var data by remember { mutableStateOf(viewModel.dataSavedGame) }

    viewModel.uiState.value.let {
        when (it) {
            GameScreenUIState.Default -> {}
            GameScreenUIState.Loading -> {
                viewModel.initGame()
                viewModel.initFirstRun()
            }
            GameScreenUIState.Changed -> {
                data = viewModel.dataSavedGame
                viewModel.uiState.value = GameScreenUIState.Default
            }
            GameScreenUIState.Saved -> {
                Toast.makeText(
                    LocalContext.current,
                    "Uloženo", // todo extract string
                    Toast.LENGTH_SHORT
                ).show()

                LaunchedEffect(it) {
                    navigation.navigateBack()
                }
            }
            GameScreenUIState.Updated -> {
                LaunchedEffect(it) {
                    navigation.navigateBack()
                }
                viewModel.uiState.value = GameScreenUIState.Saved
            }
        }
    }

    BackArrowScreen(appBarTitle = "Hra", // todo extract string
        onBackClick = {
            navigation.navigateBack()
//            ttState.show()
        }, actions = {
            if (viewModel.firstRun) {
                OutlinedButton(onClick = {
                    viewModel.alreadyFirstRun()
                    viewModel.uiState.value = GameScreenUIState.Changed
                }) {
                    Text(text = "Moje karty ->")
                }
            } else {
                PlainTooltipBox(
                    tooltip = { Text("Uložit hru") }, // todo extract string,
                ) {
                    IconButton(onClick = {
                        viewModel.saveGame()
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_save),
                            contentDescription = "Uložit hru", // todo extract string
                        )
                    }
                }
            }

            PlainTooltipBox(
                tooltip = { Text("Moje karty") }, // todo extract string,
            ) {
                IconButton(onClick = {
                    navigation.navigateToMyCardsScreen(
                        gameId = viewModel.loadGameId,
                        playerId = viewModel.dataSavedGame.playerOnTurnId
                    )
                }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_my_cards),
                        contentDescription = "Moje karty", // todo extract string
                    )
                }
            }

        }) {
        GameScreenContent(
            paddingValues = it,
            navigation = navigation,
            savedGame = data,
            viewModel = viewModel
        )
    }
}

@Composable
fun GameScreenContent(
    paddingValues: PaddingValues,
    navigation: INavigationRouter,
    savedGame: SavedGame,
    viewModel: GameScreenVM
) {

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Row {
            Button(
                onClick = {
                    viewModel.rollTheDice()
                },
                enabled = !viewModel.playing
            ) {
                Text("Hod kostkou: ${viewModel.diceNumber}")
            }

            Button(
                onClick = {
                    viewModel.endMove()
                },
                enabled = viewModel.playing
            ) {
                Text("Ukončit tah")
            }
        }

        Image(
            painter = painterResource(id = R.drawable.plan_svetly_1b), contentDescription = "planek"
        )

        // todo stav hry
        Text("Aktuální políčko:${savedGame.name ?: ""}")
        Text("Popis karty:${savedGame.id ?: ""}")


        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { /*TODO */ },
                enabled = viewModel.dataSavedGame.playerOnTurnId == 1L
            ) {
                Text("Hráč 1")// todo extract string
            }

            Spacer(modifier = Modifier.requiredWidth(16.dp))

            Button(
                onClick = { /*TODO*/ },
                enabled = viewModel.dataSavedGame.playerOnTurnId  == 2L
            ) {
                Text("Hráč 2")// todo extract string
            }

            Spacer(modifier = Modifier.requiredWidth(16.dp))

            Button(
                onClick = { /*TODO*/ },
                enabled = viewModel.dataSavedGame.playerOnTurnId  == 3L
            ) {
                Text("Hráč 3")// todo extract string
            }
        }

    }

}