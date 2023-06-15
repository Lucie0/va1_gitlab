package cz.mendelu.pef.dostihyasazky.ui.screens.card_detail

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.dostihyasazky.R
import cz.mendelu.pef.dostihyasazky.model.CardWithMoreDetails
import cz.mendelu.pef.dostihyasazky.model.MoreDetails
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter
import cz.mendelu.pef.dostihyasazky.ui.elements.BackArrowScreen
import org.koin.androidx.compose.getViewModel

@Composable
fun CardDetailScreen(
    navigation: INavigationRouter,
    id: Long?,
    viewModel: CardDetailVM = getViewModel()
) {

    viewModel.loadCardId = id

    var data by remember { mutableStateOf(viewModel.data) }

    viewModel.uiState.value.let {
        when (it) {
            CardDetailUIState.Default -> {}
            CardDetailUIState.Changed -> {
                data = viewModel.data
                viewModel.uiState.value = CardDetailUIState.Default
            }
            CardDetailUIState.Loading -> {
                viewModel.initCard()
            }
            CardDetailUIState.CannotBuyRace -> {
                Toast.makeText(
                    LocalContext.current,
                    "Nelze koupit další dostih, dosaženo maximum 5", // todo extract string
                    Toast.LENGTH_SHORT
                ).show()

                viewModel.uiState.value = CardDetailUIState.Default
            }
            CardDetailUIState.Updated -> {
                viewModel.uiState.value = CardDetailUIState.Changed
            }
        }
    }

    BackArrowScreen(
        appBarTitle = data.card.name, // todo jmeno -- PETR -- proc se mi neprokresluje hned, ale musim pockat na nejaky referesh?
        onBackClick = { navigation.navigateBack() }
    ) {
        CardDetailScreenContent(
            paddingValues = it,
            cardWithMoreDetails = data,
            viewModel = viewModel
//            CardWithMoreDetails(
//                cz.mendelu.pef.dostihyasazky.model.Card(
//                    "",
//                    0,
//                    0,
//                    0,
//                    0,
//                    1
//                ),
//                MoreDetails(
//                    "PinkStable",
//                    0,
//                    0,
//                    0
//                )
//            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardDetailScreenContent(
    paddingValues: PaddingValues,
    cardWithMoreDetails: CardWithMoreDetails,
    viewModel: CardDetailVM
) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Image(
            painter = painterResource(id = R.drawable.shagya1),
            contentDescription = null
        )

        Row(
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
            Button(onClick = { viewModel.buyRace() }) {
                Text("Koupit dostih") // todo extract string
            }
            Button(onClick = { /*TODO sell card */ }) {
                Text("Prodat kartu") // todo extract string
            }
            Button(onClick = { /*TODO show in map*/ }) {
                Text("Zobrazit v mapě") // todo extract string
            }
        }
    }

}