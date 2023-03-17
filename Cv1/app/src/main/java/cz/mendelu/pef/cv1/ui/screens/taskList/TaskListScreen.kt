package cz.mendelu.pef.cv1.ui.screens.taskList

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cz.mendelu.pef.cv1.model.Task
import cz.mendelu.pef.cv1.navigation.INavigationRouter
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListScreen(navigation: INavigationRouter,
                   viewModel: TaskListViewModel = getViewModel()) {
//    var tasks: MutableList<Task> = mutableListOf() // nepamatuje si stavajici list
    var tasks = remember { // aby si pamatoval i po znovuvykresleni screeny
        mutableStateListOf<Task>()
    }
//    tasks.add(Task("polozka 1"))
//    tasks.add(Task("polozka 2"))
//    tasks.add(Task("polozka 3"))

    viewModel.taskListUIState.value.let {  // nad promennou ve VM neco provedu
        // nemusim inicializovat poslech
        when(it) {
            TaskListUIState.Default -> {
                viewModel.loadTasks()
            }
            is TaskListUIState.Success -> {
                tasks.clear()
                tasks.addAll(it.tasks)
            }
        }
    }

    // obrazovka reprezentuje cely kontejner bar + content, kde content bude ZVLAST
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Task List Screen")
            }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navigation.navigateToAddEditTaskScreen(-1L)
            }) {
                Text(text = "+")
            }
        }
    ) {
        TaskListScreenContent(it, tasks)
    }
}

@Composable
fun TaskListScreenContent(
    paddingValues: PaddingValues, // pridany padding kvuli tomu, aby se obsah posunul od AppBaru a ten ho nezakryval
    tasks: MutableList<Task>){ // todo unmutable
    // content obrazovky
    LazyColumn(modifier = Modifier.padding(paddingValues)){
        tasks.forEach{
            item {
                Text(text = it.text)
            }
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