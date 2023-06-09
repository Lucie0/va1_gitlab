package cz.mendelu.pef.dostihyasazky.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter

@Composable
fun CardDetailScreen(navigation: INavigationRouter, id: Long?) {
    // todo fetchnout si z db do VM dany item dle predaneho id
    BackArrowScreen(
        appBarTitle = "Jmeno kone", // todo jmeno,
        onBackClick = { navigation.navigateBack() }
    ) {
        CardDetailScreenContent(
            paddingValues = it
        )
    }
}

@Composable
fun CardDetailScreenContent(
    paddingValues: PaddingValues
) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
//   todo   Image(painter = , contentDescription = )?

        Row(
//            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(

            ) {
                Text("Cena: ") // todo extract string
                Text("Stáj: ") // todo extract string
                Text("Počet dostihů: ") // todo extract string
                Text("Cena za další dostih: ") // todo extract string
            }
            Column() {
                Text("1000") //
                Text("hneda")
                Text("0")
                Text("200")
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
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