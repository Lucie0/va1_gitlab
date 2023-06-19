package cz.mendelu.pef.dostihyasazky.ui.screens.saved_game_detail

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.dostihyasazky.R
import cz.mendelu.pef.dostihyasazky.model.SavedGame
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter
import cz.mendelu.pef.dostihyasazky.ui.elements.BackArrowScreen
import cz.mendelu.pef.dostihyasazky.ui.elements.MyTextField
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedGameDetailScreen(
    navigation: INavigationRouter,
    id: Long?,
    viewModel: SavedGameDetailVM = getViewModel()
) {

    viewModel.savedGameId = id
    var data by remember { mutableStateOf(viewModel.data) }

    viewModel.uiState.value.let {
        when (it) {
            SavedGameDetailUIState.Default -> {}
            SavedGameDetailUIState.Changed -> {
                data = viewModel.data
                viewModel.uiState.value = SavedGameDetailUIState.Default
            }
            SavedGameDetailUIState.Loading -> {
                viewModel.initSavedGame()
            }
            SavedGameDetailUIState.Saved -> {
                Toast.makeText(
                    LocalContext.current,
                    "Uloženo", // todo extract string
                    Toast.LENGTH_SHORT
                ).show()

                LaunchedEffect(it) {
                    navigation.navigateBack()
                }
            }
            SavedGameDetailUIState.Deleted -> {
                Toast.makeText(
                    LocalContext.current,
                    "Smazáno", // todo extract string
                    Toast.LENGTH_SHORT
                ).show()

                LaunchedEffect(it) {
                    navigation.navigateBack()
                }
            }
        }
    }
    BackArrowScreen(
        appBarTitle = stringResource(R.string.SGD_app_bar),
        onBackClick = { navigation.navigateBack() },
        actions = {
            PlainTooltipBox(
                tooltip = { Text("Smazat hru") }, // todo extract string,
            ) {
                IconButton(onClick = {
                    viewModel.deleteGame()
                }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = null
                    )
                }
            }
        }
    ) {
        SavedGameDetailScreenContent(
            savedGame = data,
            navigation = navigation,
            viewModel = viewModel
        )
    }

}

@Composable
fun SavedGameDetailScreenContent(
    savedGame: SavedGame,
    navigation: INavigationRouter,
    viewModel: SavedGameDetailVM
) {

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    ) {

        MyTextField(
            label = stringResource(R.string.SGD_name),
            value = savedGame.name ?: "",
            enabled = true,
            onValueChange = {
                viewModel.onNameChange(it)
            })
        MyTextField(
            label = stringResource(R.string.SGD_notes),
            value = savedGame.notes ?: "",
            enabled = true,
            onValueChange = {
                viewModel.onNotesChanges(it)
            })

        MyTextField(
            label = stringResource(R.string.SGD_date),
            value = savedGame.date,
            enabled = false,
            onValueChange = {})
        MyTextField(
            label = stringResource(R.string.SGD_player_on_turn),
            value = savedGame.playerOnTurnId.toString(),
            enabled = false,
            onValueChange = {}
        )

        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            OutlinedButton(onClick = { viewModel.updateGame() }) {
                Text(text = stringResource(R.string.SGD_save_changes))
            }
            Spacer(Modifier.requiredWidth(32.dp))
            OutlinedButton(onClick = {
//                println(":)" + savedGame.id)
                navigation.navigateToGameScreen(savedGame.id)
            }) {
                Text(text = stringResource(R.string.SGD_load_game))
            }
        }

    }


}