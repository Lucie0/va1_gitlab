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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.dostihyasazky.R
import cz.mendelu.pef.dostihyasazky.model.CardWithMoreDetails
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

    viewModel.loadGameId = savedGameId

    var dataSavedGame by remember { mutableStateOf(viewModel.dataSavedGame) }
    var dataCardWithDetails by remember { mutableStateOf(viewModel.actualCardWithDetails) }

    viewModel.uiState.value.let {
        when (it) {
            GameScreenUIState.Default -> {}
            GameScreenUIState.Loading -> {
//                println(":)" + viewModel.dataSavedGame.playerOnTurnId)
                viewModel.init()
            }
            GameScreenUIState.Changed -> {
                dataSavedGame = viewModel.dataSavedGame
                dataCardWithDetails = viewModel.actualCardWithDetails
                viewModel.uiState.value = GameScreenUIState.Default
            }
            GameScreenUIState.Saved -> {
                Toast.makeText(
                    LocalContext.current,
                    stringResource(R.string.Toast_saved),
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

//            GameScreenUIState.CardLoaded -> {
//                dataCardWithDetails = viewModel.actualCardWithDetails
//                viewModel.uiState.value = GameScreenUIState.Default
//            }
//            GameScreenUIState.PlayerInitialized -> {
//                dataCardWithDetails = viewModel.actualCardWithDetails
//                viewModel.loadCard()
//            }
//            GameScreenUIState.PlayerSaved -> {
//                dataCardWithDetails = viewModel.actualCardWithDetails
//                viewModel.initPlayer()
//            }
            GameScreenUIState.CardLoaded -> {
                dataCardWithDetails = viewModel.actualCardWithDetails
                viewModel.uiState.value = GameScreenUIState.Default
            }

//            GameScreenUIState.PlayerSaved -> {
//                dataCardWithDetails = viewModel.actualCardWithDetails
//                viewModel.uiState.value = GameScreenUIState.Default
//            }
            GameScreenUIState.Initialized -> {
                dataCardWithDetails = viewModel.actualCardWithDetails
                viewModel.uiState.value = GameScreenUIState.Default
            }
        }
    }

    BackArrowScreen(appBarTitle = stringResource(R.string.G_game_app_bar),
        onBackClick = {
            navigation.navigateBack()
//            ttState.show()
        }, actions = {
            if (viewModel.firstRun) {
                OutlinedButton(onClick = {
                    viewModel.alreadyFirstRun()
//                    viewModel.uiState.value = GameScreenUIState.Changed
                }) {
                    Text(text = stringResource(R.string.G_info_btn_my_cards))
                }
            } else {
                PlainTooltipBox(
                    tooltip = { Text(stringResource(R.string.G_save_game)) },
                ) {
                    IconButton(onClick = {
                        viewModel.saveGame()
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_save),
                            contentDescription = null,
                        )
                    }
                }
            }

            PlainTooltipBox(
                tooltip = { Text(stringResource(R.string.G_my_cards)) },
            ) {
                IconButton(onClick = {
                    println(":)" + viewModel.loadGameId +
                        "playerId =" + viewModel.playerOnTurn)
                    navigation.navigateToMyCardsScreen(
                        gameId = viewModel.loadGameId,
                        playerId = viewModel.playerOnTurn
                    )
                }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_my_cards),
                        contentDescription = null,
                    )
                }
            }

        }) {
        GameScreenContent(
            paddingValues = it,
            navigation = navigation,
            savedGame = dataSavedGame,
            cardWDetails = dataCardWithDetails,
            viewModel = viewModel
        )
    }
}

@Composable
fun GameScreenContent(
    paddingValues: PaddingValues,
    navigation: INavigationRouter,
    savedGame: SavedGame,
    cardWDetails: CardWithMoreDetails,
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
                Text(stringResource(R.string.G_roll_the_dice)  + viewModel.diceNumber )
            }

            Button(
                onClick = {
                    viewModel.endMove()
                },
                enabled = viewModel.playing
            ) {
                Text(stringResource(R.string.G_end_move))
            }
        }

        Image(
            painter = painterResource(id = R.drawable.plan_svetly_1b), contentDescription = null
        )

        // todo stav hry
        Text(stringResource(R.string.G_actual_field) + viewModel.actualCardWithDetails.card.name)
        Text(stringResource(R.string.G_card_description) + viewModel.actualCardWithDetails)
//        Text("actual field: ${viewModel.actualField}")
//        Text("data player field: ${viewModel.dataPlayers[(viewModel.playerOnTurn-1).toInt()].field}")
//        Text("data player field: ${viewModel.dataPlayers}")

        Text(stringResource(R.string.G_player_account) + viewModel.getAccountOfActualPlayer())

        if(viewModel.actualCardWithDetails.card.cardTypeID == 1 && viewModel.playing){
            OutlinedButton(onClick = { /*TODO vm.buyCard*/ }) {
                Text(stringResource(R.string.G_buy_card))
            }
        }


        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {},
                enabled = viewModel.playerOnTurn == 1L
            ) {
                Text(stringResource(R.string.G_player_1))
            }

            Spacer(modifier = Modifier.requiredWidth(16.dp))

            Button(
                onClick = {},
                enabled = viewModel.playerOnTurn  == 2L
            ) {
                Text(stringResource(R.string.G_player_2))
            }

            Spacer(modifier = Modifier.requiredWidth(16.dp))

            Button(
                onClick = {},
                enabled = viewModel.playerOnTurn  == 3L
            ) {
                Text(stringResource(R.string.G_player_3))
            }
        }

    }

}