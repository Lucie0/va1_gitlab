package cz.mendelu.pef.midterm2.ui.screens

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
import cz.mendelu.pef.midterm2.model.Player
import cz.mendelu.pef.midterm2.navigation.INavigationRouter
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayersListScreen(
    navigation: INavigationRouter,
    viewModel: PlayersListVM = getViewModel()
) {

    var players = remember { // aby si pamatoval i po znovuvykresleni screeny
        mutableStateListOf<Player>()
    }

//    players.add(Player("fname lname1"))
//    players.add(Player("fname lname2"))
//    players.add(Player(name = "fname lname3"))

    viewModel.playersListUIState.value.let {
        when(it){
            PlayersListUIState.Default -> {
                viewModel.load()
            }
            is PlayersListUIState.Success -> {
                players.clear()
                players.addAll(it.items)
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Players List")
            }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
//                navigation.navigateToAddCarScreen()
                // todo navigate to addplayer -1L?
                navigation.navigateToAddPlayerScreen(-1L)
            }) {
//                Text(text = "+")
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    )
    {
        PlayersListScreenContent(
            paddingValues = it,
            players = players,
            navigation = navigation
        )
    }

}

@Composable
fun PlayersListScreenContent(
    paddingValues: PaddingValues,
    players: MutableList<Player>,
    navigation: INavigationRouter
){

    LazyColumn(modifier = Modifier.padding(paddingValues)){
        item {
            Text(text = "Count of Players on match: ${players.filter { i -> i.onMatch }.count()} from ${players.count()}") // todo count of mutable list from VM
        }
        players.forEach{
            item {
                Text(it.name)
                MyRow(player = it,
                onRowClick = {
                    navigation.navigateToPlayerOnMatchScreen(it.id)
                })
            }
        }
    }
}

@Composable
fun MyRow(
    player: Player,
    onRowClick: () -> Unit,
    // todo viewmodel / actions
){
//    var playerOnMatch: Boolean by remember {
//        mutableStateOf(player.onMatch)
//    }

    Row(modifier = Modifier.clickable(onClick = onRowClick)) {
        Column {
            Text(text = player.name)
        }
    }

}

/*
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

 */