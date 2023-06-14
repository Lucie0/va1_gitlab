package cz.mendelu.pef.dostihyasazky.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        SettingsScreenContent(
            navigation = navigation
        )

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreenContent(
    navigation: INavigationRouter
) {
    ListItem(
        headlineText = {Text("Verze")},
        supportingText = { Text(text = BuildConfig.VERSION_NAME )}
    )
    Divider()

    ListItem(
        headlineText = {Text("Pravidla hry")},
        modifier = Modifier.clickable{ navigation.navigateToRulesScreen()}
    )

}
