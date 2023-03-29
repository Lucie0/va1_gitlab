package cz.mendelu.pef.test1.ui.screens.mainScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import cz.mendelu.pef.test1.navigation.INavigationRouter

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter") // todo undo
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navigation: INavigationRouter) { // todo volat ji v hlavni app tride -> vytvorit ji

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Main Screen")
            }
            )
        },
//        floatingActionButton = {
//            FloatingActionButton(onClick = {
////                navigation.navigateToAddEditTaskScreen(-1L)
//            }) {
//                Text(text = "+")
//            }
//        }
    ) {
//        TaskListScreenContent(it, tasks, navigation, actions = viewModel) // VM dedi z actions, proto ho predavam
        MainScreenContent(it, navigation)
    }
}

@Composable
fun MainScreenContent(paddingValues: PaddingValues, navigation: INavigationRouter) {
    Column(modifier = Modifier.padding(paddingValues)) {
        Text(text = "Number of words: ")
        
        Button(onClick = {
            // navigate to AddItem screen
            navigation.navigateToAddItemScreen()
        }) {
            Text(text = "New word", fontWeight = FontWeight.Bold)
        }

        Button(onClick = {
            // navigate to ListOfWordsScreen
            navigation.navigateToListOfWordsScreen()
        }) {
            Text(text = "List of words")
        }
    }

}