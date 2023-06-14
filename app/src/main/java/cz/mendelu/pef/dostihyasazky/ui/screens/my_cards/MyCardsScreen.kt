package cz.mendelu.pef.dostihyasazky.ui.screens.my_cards

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cz.mendelu.pef.dostihyasazky.model.Card
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter
import cz.mendelu.pef.dostihyasazky.ui.screens.BackArrowScreen
import androidx.compose.material3.Card as Card1
import cz.mendelu.pef.dostihyasazky.R

@Composable
fun MyCardsScreen(
    navigation: INavigationRouter
) {
    var cards = remember { mutableStateListOf<Card>() }

    cards.add(
        Card(
            name = "horse1",
            image = R.drawable.nokota8,
            historicalCost = 5600,
            fixFee = 0,
            paymentTypeID = 1,
            cardTypeID = 1,
            moreDetailsID = 1
//            paymentType = "vlastnictvi",
//            cardType = "Kun"
        )
    )
    cards.add(
        Card(
            name = "horse2",
            image = R.drawable.appaloosa_hneda8,
            historicalCost = 5600,
            fixFee = 0,
            paymentTypeID = 1,
            cardTypeID = 1,
            moreDetailsID = 1
//            paymentType = "vlastnictvi",
//            cardType = "Kun"
        )
    )

    BackArrowScreen(
        appBarTitle = "Moje karty",// todo extract string
        onBackClick = { navigation.navigateBack() },
        drawFullScreenContent = true
    )
    {
        MyCardsScreenContent(
            paddingValues = it,
            cards = cards,
            navigation = navigation
        )
    }

}

@Composable
fun MyCardsScreenContent(
    paddingValues: PaddingValues,
    cards: List<Card>,
    navigation: INavigationRouter
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp),
        modifier = Modifier.padding(paddingValues),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ), content = {
            items(cards) {
                Card1(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .height(128.dp)
                        .clickable { navigation.navigateToCardDetailScreen(1) }, // todo it.id, spravne id dle zvoleneho obrazku
                colors = CardDefaults.cardColors()
                ) {

                    Box(
                        modifier = Modifier.background(Color(255, 148, 148, 255)) // todo color from horse' stable
                    ){
                        Image(
                            alignment = Alignment.Center,
                            painter = painterResource(id = it.image),
                            contentDescription = it.name,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxSize()
                        )
                    }

                }

            }
        }
    )
}