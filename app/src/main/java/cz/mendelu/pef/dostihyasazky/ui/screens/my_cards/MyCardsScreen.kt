package cz.mendelu.pef.dostihyasazky.ui.screens.my_cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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

    cards.add(Card("horse1"))
    cards.add(Card("horse2"))

    BackArrowScreen(
        appBarTitle = "Moje karty",// todo extract string
        onBackClick = { navigation.navigateBack() })
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
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        cards.forEach {
            Row(
                modifier = Modifier.clickable { navigation.navigateToCardDetailScreen(1) }//it.id) } // todo spravne id dle zvoleneho obrazku
            ) {
                Text(it.name)
            }
        }
    }
}

/*
LazyVerticalGrid(columns = GridCells.Adaptive(128.dp),
    contentPadding = PaddingValues(
        start = 12.dp,
        top = 16.dp,
        end = 12.dp,
        bottom = 16.dp
    ), content = {
        items(cards.size) {
            Card1(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    text = cards[it].name,
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
*/


//    LazyVerticalGrid( // todo PETR proc ne lazy Column a kde se tedy vyuziva? hazi error
//        //Vertically scrollable component was measured with an infinity maximum height constraints,
//        // which is disallowed. One of the common reasons is nesting layouts like LazyColumn and
//        // Column(Modifier.verticalScroll()). If you want to add a header before the list of items
//        // please add a header as a separate item() before the main items() inside the LazyColumn scope.
//        // There are could be other reasons for this to happen: your ComposeView was added into a
//        // LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true)
//        // or wrote a custom layout. Please try to remove the source of infinite constraints in
//        // the hierarchy above the scrolling container.
//        //
//        columns = GridCells.Adaptive(minSize = 128.dp),
//        modifier = Modifier.padding(horizontal = 16.dp),
////        contentPadding = paddingValues
//    ) {
//        cards.forEach {
//            item(key = it.id) {
//
//                Text(it.name)
//                Divider()
//            }
//        }

//----

//        cards.forEach {
//            Text(it.name)
//        }


// toto funguje vvv
//@Composable
//fun LazyVerticalGridDemo(){
//    val list = (1..10).map { it.toString() }
//
//    LazyVerticalGrid(
//        columns = GridCells.Adaptive(128.dp),
//
//        // content padding
//        contentPadding = PaddingValues(
//            start = 12.dp,
//            top = 16.dp,
//            end = 12.dp,
//            bottom = 16.dp
//        ),
//        content = {
//            items(list.size) { index ->
//                Card1(
//                    modifier = Modifier
//                        .padding(4.dp)
//                        .fillMaxWidth(),
//                ) {
//                    Text(
//                        text = list[index],
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 30.sp,
//                        color = Color(0xFFFFFFFF),
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier.padding(16.dp)
//                    )
//                }
//            }
//        }
//    )
//}