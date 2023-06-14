package cz.mendelu.pef.dostihyasazky.ui.screens.game

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.dostihyasazky.R
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter
import cz.mendelu.pef.dostihyasazky.ui.elements.BackArrowScreen
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(
    navigation: INavigationRouter, viewModel: GameScreenVM = getViewModel()
) {

//    val ttState = TooltipState()
//    if (!ttState.isVisible){
//        ttState.show()
//    }
//    ttState.show()

    viewModel.uiState.value.let {
        when (it) {
            GameScreenUIState.Default -> {}
            GameScreenUIState.Loading -> {
                // todo inicializace rozehrane hry
                viewModel.initFirstRun()
            }
            GameScreenUIState.Changed -> {
                viewModel.uiState.value = GameScreenUIState.Default
            }
            GameScreenUIState.Saved -> {
                Toast.makeText(
                    LocalContext.current, "Ulozeno", // todo extract string
                    Toast.LENGTH_SHORT
                ).show()

                LaunchedEffect(it) {
                    navigation.navigateBack()
                }
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
                IconButton(onClick = { navigation.navigateToMyCardsScreen() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_my_cards),
                        contentDescription = "Moje karty", // todo extract string
                    )
                }
            }

        }) {
        GameScreenContent(
            paddingValues = it, navigation = navigation, viewModel = viewModel
        )
    }
}

@Composable
fun GameScreenContent(
    paddingValues: PaddingValues, navigation: INavigationRouter, viewModel: GameScreenVM
) {

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Button(
            onClick = { /*TODO call vm hod kostkou*/
                viewModel.rollTheDice()
            }, enabled = true
        ) {
            Text("Hod kostkou: ${viewModel.diceNumber}") //todo diceNumber
        }
        Image(
            painter = painterResource(id = R.drawable.plan_svetly_1b), contentDescription = "planek"
        )

        // todo stav hry
        Text("Aktuální políčko:")
        Text("Popis karty:")


        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { /*TODO */ }) {
                Text("Hráč 1")// todo extract string
            }

            Spacer(modifier = Modifier.requiredWidth(16.dp))

            Button(onClick = { /*TODO*/ }) {
                Text("Hráč 2")// todo extract string
            }

            Spacer(modifier = Modifier.requiredWidth(16.dp))

            Button(onClick = { /*TODO*/ }) {
                Text("Hráč 3")// todo extract string
            }
        }

    }

}