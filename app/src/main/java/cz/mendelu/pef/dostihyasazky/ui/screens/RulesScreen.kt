package cz.mendelu.pef.dostihyasazky.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter

@Composable
fun RulesScreen(navigation: INavigationRouter) {

    BackArrowScreen(
        appBarTitle = "Pravidla hry", // todo extract string
        onBackClick = { navigation.navigateBack() }
    ) {
        RulesScreenContent()
    }
}

@Composable
fun RulesScreenContent() {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            "Cílem hry je získat nejvíce kompletních stájí a umístit své koně na co nejvíce dostihů. \n" +
                    "Včetně hlavního dostihu sezóny.\n" +
                    "Na začátku hry má každý z hráčů počáteční vklad 30 000 dostihových korun (DK). " +
                    "Hráč, který je na řadě, provede hod kostkou a postoupí svou figurkou o daný počet " +
                    "políček vpřed. Pokud padne na kostce číslo 6, hráč háže ještě jednou. Hody se sčítají " +
                    "a figurka postupuje vřed o součet obou hodů. Po provedení tahu hráč vykoná akci, která " +
                    "vyplývá z políčka, na kterém ukončil svůj tah. Pokud na kostce dvakrát po sobě padne " +
                    "číslo 6, hráč se přesune na políčko Distanc a neúčastní se dostihů po dobu 2 kol."
        )
    }

}