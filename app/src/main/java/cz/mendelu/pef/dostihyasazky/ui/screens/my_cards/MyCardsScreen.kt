package cz.mendelu.pef.dostihyasazky.ui.screens.my_cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cz.mendelu.pef.dostihyasazky.model.Card
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter
import cz.mendelu.pef.dostihyasazky.ui.screens.BackArrowScreen
import androidx.compose.material3.Card as Card1

@Composable
fun MyCardsScreen(
    navigation: INavigationRouter
) {
    var cards = remember { mutableStateListOf<Card>() }

    cards.add(Card("horse1", 5600,0, "vlastnictvi",
        "Kun"))
    cards.add(Card("horse2", 5600,0, "vlastnictvi",
        "Kun"))

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
                        .clickable { navigation.navigateToCardDetailScreen(1) }, // todo it.id, spravne id dle zvoleneho obrazku
                ) {
                    Text(
                        text = it.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp)
                    )
                }

            }
        }
    )
}