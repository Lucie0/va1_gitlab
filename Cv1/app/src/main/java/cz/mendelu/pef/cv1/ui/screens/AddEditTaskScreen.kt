package cz.mendelu.pef.cv1.ui.screens

import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cz.mendelu.pef.cv1.navigation.INavigationRouter
import cz.mendelu.pef.cv1.ui.elements.BackArrowScreen

@Composable
fun AddEditTaskScreen(
    navigation: INavigationRouter,
    id: Long?
){
    BackArrowScreen(
        appBarTitle = "Add Edit Task Screen",
        onBackClick = {
            navigation.navigateBack()
        }) {
        AddEditTaskScreenContent()
    }
}

@Composable
fun AddEditTaskScreenContent(){
    Text(text = "Text")
}