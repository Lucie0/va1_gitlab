package cz.mendelu.pef.dostihyasazky.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.dostihyasazky.R
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter
import cz.mendelu.pef.dostihyasazky.ui.elements.BackArrowScreen

@Composable
fun RulesScreen(navigation: INavigationRouter) {

    BackArrowScreen(
        appBarTitle = stringResource(R.string.R_app_bar),
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
            stringResource(R.string.R_rules)
        )
    }

}