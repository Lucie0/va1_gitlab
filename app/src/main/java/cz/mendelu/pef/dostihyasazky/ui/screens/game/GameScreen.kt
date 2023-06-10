package cz.mendelu.pef.dostihyasazky.ui.screens.game

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.dostihyasazky.R
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter
import cz.mendelu.pef.dostihyasazky.ui.screens.BackArrowScreen

@Composable
fun GameScreen(
    navigation: INavigationRouter
) {
    BackArrowScreen(
        appBarTitle = "Hra", // todo extract string
        onBackClick = { navigation.navigateBack() },
        actions = {
            IconButton(onClick = { navigation.navigateToMyCardsScreen() }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_my_cards),
                    contentDescription = "Moje karty", // todo extract string
                )
//                Text(text = "Moje karty")
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