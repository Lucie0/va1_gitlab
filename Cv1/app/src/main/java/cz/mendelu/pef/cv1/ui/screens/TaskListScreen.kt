package cz.mendelu.pef.cv1.ui.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListScreen(){
    // obrazovka reprezentuje cely kontejner bar + content, kde content bude ZVLAST
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(text = "Task List Screen")
                }
            )},
        floatingActionButton = {
            FloatingActionButton(onClick = {

            }) {
            }
        }
    ) {
        TaskListScreenContent()
    }
}

@Composable
fun TaskListScreenContent(){
    // content obrazovky
    Text(text = "Text")
}