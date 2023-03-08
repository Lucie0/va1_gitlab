package cz.mendelu.pef.cv1.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import cz.mendelu.pef.cv1.model.Task
import cz.mendelu.pef.cv1.navigation.INavigationRouter
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListScreen(navigation: INavigationRouter,
                   viewModel: TaskListViewModel = getViewModel()) {
    var tasks: MutableList<Task> = mutableListOf()
    tasks.add(Task("polozka 1"))
    tasks.add(Task("polozka 2"))
    tasks.add(Task("polozka 3"))

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
//                navigation.navigateToAddEditTaskScreen(-1L)
                viewModel.insert()
            }) {
            }
        }
    ) {
        TaskListScreenContent(tasks)
    }
}

@Composable
fun TaskListScreenContent(tasks: MutableList<Task>){ // todo unmutable
    // content obrazovky
    LazyColumn(){
        tasks.forEach{
            item { Text(text = it.text) }
        }


//        seznam
//        item {
//            Text(text = "Polozka seznamu")
//        }
//
//
//        item {
//            Text(text = "Polozka seznamu 2")
//        }
    }
}