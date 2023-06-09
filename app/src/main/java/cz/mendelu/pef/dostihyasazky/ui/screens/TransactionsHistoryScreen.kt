package cz.mendelu.pef.dostihyasazky.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.dostihyasazky.model.Transaction
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter

@Composable
fun TransactionsHistoryScreen(navigation: INavigationRouter) {

    var transactions = remember { mutableStateListOf<Transaction>() }

    transactions.add(Transaction("Pocatecni zisk", 30000))
    transactions.add(Transaction("Klinika", -1000))

    BackArrowScreen(
        appBarTitle = "Historie transakci hrace :", //todo add player // todo extract string
        onBackClick = { navigation.navigateBack() }
    ) {
        TransactionsHistoryScreenContent(
            transactions = transactions
        )
    }
}

@Composable
fun TransactionsHistoryScreenContent(
    transactions: List<Transaction>
) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        transactions.forEach {
            Row {
                Text(text = it.event + ": ")
                Text(text = it.value.toString())
            }
        }
    }

}