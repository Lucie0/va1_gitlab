package cz.mendelu.pef.dostihyasazky.ui.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cz.mendelu.pef.dostihyasazky.BuildConfig
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter
import cz.mendelu.pef.dostihyasazky.ui.elements.BackArrowScreen

@Composable
fun SettingsScreen(
    navigation: INavigationRouter
) {

    BackArrowScreen(
        appBarTitle = "Info",
        onBackClick = { navigation.navigateBack() }
    ) {
        SettingsScreenContent()

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreenContent() {
    ListItem(
        headlineText = {Text("Verze")},
        supportingText = { Text(text = BuildConfig.VERSION_NAME )}
    )

}
