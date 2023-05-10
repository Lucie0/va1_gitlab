package cz.mendelu.pef.cv1.ui.screens.taskList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
//                Text(text = "+")
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) {
        TaskListScreenContent(it, tasks, navigation, actions = viewModel) // VM dedi z actions, proto ho predavam
    }
}

@Composable
fun TaskListScreenContent(
    paddingValues: PaddingValues, // pridany padding kvuli tomu, aby se obsah posunul od AppBaru a ten ho nezakryval
    tasks: MutableList<Task>, // todo unmutable
    navigation: INavigationRouter,
    actions: TaskListActions
) {
    // content obrazovky
    LazyColumn(modifier = Modifier.padding(paddingValues)){
        tasks.forEach{
            item(key = it.id) { // aby se nerefreshovaly zaznamy, ktere jsou stale stejne, predani jedinecneho id
                TaskRow(
                    task = it,
                    onRowClick = { navigation.navigateToAddEditTaskScreen(it.id) },
                    actions = actions)
            }
        }
//        seznam
//        item {
//            Text(text = "Polozka seznamu")
//        }
//        item {
//            Text(text = "Polozka seznamu 2")
//        }
    }
}

// zobrazeni dat
// klikaci
// potreba zapsat do db
@Composable
fun TaskRow(
    task: Task, // je to klikaci -- budto poslat cil, kam se to ma presmerovat, nebo zachycovat kliknuti
    onRowClick: () -> Unit,
    actions: TaskListActions
){
    // stav -- pro kazdeho samostatne
    var taskState: Boolean by remember {
        mutableStateOf(task.taskState)
    }

    // klikaci radek -- predani
    Row(modifier = Modifier.clickable(onClick = onRowClick)) {
        Checkbox(checked = taskState, onCheckedChange = {
            actions.changeTaskState(id = task.id!!, state = it) // !! app muze spadnout --> ale to je dobre, dozvime se o tom
            // ^ vyvola rekompozici
            taskState = it // ulozeni noveho stavu
        }) // zmena stavu objektu, zobrazeni i v db
        Column {
            // samotny nazev ukolu
            Text(text = task.text)
//            popisek
//            Text(text = it.id)
        }
    }
}