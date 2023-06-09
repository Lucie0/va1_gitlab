package cz.mendelu.pef.dostihyasazky.ui.screens.game

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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

        // todo image of gameplan
        // Image()

        Row() {
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