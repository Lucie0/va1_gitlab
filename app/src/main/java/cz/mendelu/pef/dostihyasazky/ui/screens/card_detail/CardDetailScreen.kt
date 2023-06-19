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
import androidx.compose.ui.res.stringResource
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
                    stringResource(R.string.Toast_max_races_cannot_buy_race),
                    Toast.LENGTH_SHORT
                ).show()

                viewModel.uiState.value = CardDetailUIState.Default
            }
            CardDetailUIState.Updated -> {
                viewModel.uiState.value = CardDetailUIState.Changed
            }
            CardDetailUIState.BoughtRace -> {
                Toast.makeText(
                    LocalContext.current,
                    stringResource(R.string.Toast_race_bought),
                    Toast.LENGTH_SHORT
                ).show()

                viewModel.uiState.value = CardDetailUIState.Default
            }
        }
    }

    BackArrowScreen(
        appBarTitle = "Jmeno:" + data.card.name, // todo jmeno -- PETR -- proc se mi neprokresluje hned, ale musim pockat na nejaky referesh?
        onBackClick = { navigation.navigateBack() }
    ) {
        CardDetailScreenContent(
            paddingValues = it,
            cardWithMoreDetails = data,
            navigation = navigation,
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
    navigation: INavigationRouter,
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
                Divider()
                ListItem(
                    headlineText = { Text(stringResource(R.string.CD_historical_cost)) },
                    supportingText = { Text(cardWithMoreDetails.card.historicalCost.toString()) }
                )
                ListItem(
                    headlineText = { Text(stringResource(R.string.CD_stable_visit_cost)) },
                    supportingText = { Text(cardWithMoreDetails.moreDetails.stableVisitCost.toString()) }
                )
                Divider()
                ListItem(
                    headlineText = { Text(stringResource(R.string.CD_race_count)) },
                    supportingText = { Text(cardWithMoreDetails.moreDetails.raceCount.toString()) }
                )
                ListItem(
                    headlineText = { Text(stringResource(R.string.CD_race_cost)) },
                    supportingText = { Text(cardWithMoreDetails.moreDetails.raceCost.toString()) }
                )
                ListItem(
                    headlineText = { Text(stringResource(R.string.CD_race_profit)) },
                    supportingText = { Text(cardWithMoreDetails.moreDetails.raceProfit.toString()) }
                )
                Divider()
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { viewModel.buyRace() }) {
                Text(stringResource(R.string.CD_buy_race))
            }
            Button(onClick = { /*TODO sell card */ }) {
                Text(stringResource(R.string.CD_sell_card))
            }
            Button(
                onClick = {
                    navigation.navigateToMapScreen(
                        cardWithMoreDetails.moreDetails.latitude!!,
                        cardWithMoreDetails.moreDetails.longitude!!
                    )
                },
                enabled = cardWithMoreDetails.moreDetails.latitude != null && cardWithMoreDetails.moreDetails.longitude != null
            ) {
                Text(stringResource(R.string.CD_show_in_map))
            }
        }
    }

}