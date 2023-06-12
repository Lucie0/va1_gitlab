package cz.pef.mendelu.exam.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cz.pef.mendelu.exam.model.Fault
import cz.pef.mendelu.exam.navigation.INavigationRouter
import cz.pef.mendelu.exam.ui.elements.MyRow
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FaultsListScreen(
    navigation: INavigationRouter,
    viewModel: FaultsListVM = getViewModel()
) {

    var faults = remember{ mutableStateListOf<Fault>() }

    viewModel.uiState.value.let {
        when(it){
            FaultsListUIState.Default -> {
                viewModel.load()
            }
            is FaultsListUIState.Success -> {
                faults.clear()
                faults.addAll(it.items)
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Seznam prohresku") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navigation.navigateToAddFaultScreen()
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) {
        FaultsListScreenContent(
            paddingValues = it,
            faults = faults,
            viewModel = viewModel
        )

    }
}


@Composable
fun FaultsListScreenContent(
    paddingValues: PaddingValues,
    faults: List<Fault>,
    viewModel: FaultsListVM
) {
    Column (
        modifier = Modifier.padding(paddingValues).padding(horizontal = 16.dp)
    ) {
        Text(
            "Pocet bodu: ${viewModel.sumPoints}",
            color = viewModel.color,
            fontWeight = viewModel.font
        )

        LazyColumn() {
            faults.forEach {
                item {
                    MyRow(item = it)
                    Divider()
                }
            }
        }
    }

}