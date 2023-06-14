package cz.mendelu.pef.dostihyasazky.ui.screens.game

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.dostihyasazky.R
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter
import cz.mendelu.pef.dostihyasazky.ui.elements.BackArrowScreen
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(
    navigation: INavigationRouter,
    viewModel: GameScreenVM = getViewModel()
) {

    val ttState = TooltipState()
//    if (!ttState.isVisible){
//        ttState.show()
//    }
//    ttState.show()

    BackArrowScreen(
        appBarTitle = "Hra", // todo extract string
        onBackClick = {
            navigation.navigateBack()
//            ttState.show()
        },
        actions = {

//         todo   if(vm.firstRun){
            OutlinedButton(
                onClick = {
//                TODO vm.hide tooltip and set to datastore firstRun na false
                }
            ) {
                Text(text = "Moje karty ->")
            }
//         todo   }

            PlainTooltipBox(
                tooltip = { Text("Moje karty") }, // todo extract string,
//                tooltipState = ttState
            ) {
                IconButton(onClick = { navigation.navigateToMyCardsScreen() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_my_cards),
                        contentDescription = "Moje karty", // todo extract string
                    )
                }
            }

        }
    ) {
        GameScreenContent(
            paddingValues = it,
            navigation = navigation
        )
    }
}

@Composable
fun GameScreenContent(
    paddingValues: PaddingValues,
    navigation: INavigationRouter
) {

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {

        Button(
            onClick = { /*TODO call vm hod kostkou*/

//                Toast.makeText(
//                    LocalContext.current,
//                    stringResource(androidx.compose.runtime.R.string.contact_added),
//                    Toast.LENGTH_SHORT
//                ).show()
            },
            enabled = true
        ) {
            Text("Hod kostkou:") //todo diceNumber
        }
        Image(
            painter = painterResource(id = R.drawable.plan_svetly_1b),
            contentDescription = "planek"
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

            Button(onClick = { /*TODO*/ }) {
                Text("Hráč 2")// todo extract string
            }

            Button(onClick = { /*TODO*/ }) {
                Text("Hráč 3")// todo extract string
            }
        }

    }

}