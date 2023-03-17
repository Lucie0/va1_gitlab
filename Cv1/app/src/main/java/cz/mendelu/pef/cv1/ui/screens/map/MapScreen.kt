package cz.mendelu.pef.cv1.ui.screens

import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cz.mendelu.pef.cv1.ui.elements.BackArrowScreen

@Composable
fun MapScreen(){
    BackArrowScreen(
        appBarTitle = "Map Screen",
        onBackClick = {
            // TODO navigace zpet
        }) {
        MapScreenContent()
    }
}

@Composable
fun MapScreenContent(){
    Text(text = "Text")
}