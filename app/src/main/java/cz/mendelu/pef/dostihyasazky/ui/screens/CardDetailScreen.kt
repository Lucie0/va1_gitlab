package cz.mendelu.pef.dostihyasazky.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.dostihyasazky.R
import cz.mendelu.pef.dostihyasazky.model.CardWithMoreDetails
import cz.mendelu.pef.dostihyasazky.model.MoreDetails
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter
import cz.mendelu.pef.dostihyasazky.ui.elements.BackArrowScreen
import cz.mendelu.pef.dostihyasazky.ui.theme.PinkStable

@Composable
fun CardDetailScreen(
    navigation: INavigationRouter, id: Long?
) {
    // todo fetchnout si z db do VM dany item dle predaneho id

    BackArrowScreen(
        appBarTitle = "Jmeno kone", // todo jmeno,
        onBackClick = { navigation.navigateBack() }
    ) {
        CardDetailScreenContent(
            paddingValues = it,
            cardWithMoreDetails = CardWithMoreDetails(
                cz.mendelu.pef.dostihyasazky.model.Card(
                    "",
                    0,
                    0,
                    0,
                    0,
                    0,
                    1
                ),
                MoreDetails(
                    1,
                    "PinkStable",
                    0,
                    0,
                    0
                )
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardDetailScreenContent(
    paddingValues: PaddingValues,
    cardWithMoreDetails: CardWithMoreDetails
) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Image(
            painter = painterResource(id = R.drawable.shagya1),
            contentDescription = null
        )

        Row(
//            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                ListItem(
                    headlineText = { Text("Pořizovací cena") },// todo extract string
                    supportingText = { Text(cardWithMoreDetails.card.historicalCost.toString()) }
                )
                ListItem(
                    headlineText = { Text("Prohlídka stáje") },// todo extract string
                    supportingText = { Text(cardWithMoreDetails.moreDetails.stableVisitCost.toString()) }
                )
                Divider()
                ListItem(
                    headlineText = { Text("Počet dostihů") },// todo extract string
                    supportingText = { Text(cardWithMoreDetails.moreDetails.raceCount.toString()) }
                )
                ListItem(
                    headlineText = { Text("Cena za další dostih") },// todo extract string
                    supportingText = { Text(cardWithMoreDetails.moreDetails.raceCost.toString()) }
                )
                ListItem(
                    headlineText = { Text("Zisk z dostihu") },// todo extract string
                    supportingText = { Text(cardWithMoreDetails.moreDetails.raceCost.toString()) }
                )
                Divider()

//                Text("Cena: ")
//                Text("Stáj: ") // todo extract string
//                Text("Počet dostihů: ") // todo extract string
//                Text("Cena za další dostih: ") // todo extract string
//            }
//            Column() {
//                Text("1000") //
//                Text("hneda")
//                Text("0")
//                Text("200")
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text("Koupit dostih") // todo extract string
            }
            Button(onClick = { /*TODO*/ }) {
                Text("Prodat kartu") // todo extract string
            }
            Button(onClick = { /*TODO*/ }) {
                Text("Zobrazit v mapě") // todo extract string
            }
        }
    }

}