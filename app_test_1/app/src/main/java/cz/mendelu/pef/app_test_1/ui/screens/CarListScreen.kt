package cz.mendelu.pef.app_test_1.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cz.mendelu.pef.app_test_1.model.Car
import cz.mendelu.pef.app_test_1.navigation.INavigationRouter
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarListScreen(
    navigation: INavigationRouter,
    viewModel: CarListVM = getViewModel()
) {

    var cars = remember { // aby si pamatoval i po znovuvykresleni screeny
        mutableStateListOf<Car>()
    }

//    cars.add(Car("ABC0001"))
//    cars.add(Car("ABC0001"))
//    cars.add(Car("ABC0001"))
//    cars.add(Car("ABC0001"))

    viewModel.carListUIState.value.let {  // nad promennou ve VM neco provedu
        when(it) {
            CarListUIState.Default -> {
                viewModel.load()
            }
            is CarListUIState.Success -> {
                cars.clear()
                cars.addAll(it.items)
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Car List")
            }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navigation.navigateToAddCarScreen()
            }) {
//                Text(text = "+")
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    )
    {
        CarListScreenContent(
            paddingValues = it,
            cars = cars
        )
    }
}

@Composable
fun CarListScreenContent(
    paddingValues: PaddingValues,
    cars: MutableList<Car>
) {
    LazyColumn(modifier = Modifier.padding(paddingValues)) {
        cars.forEach {
            item() {
                Text(it.spz)
            }
        }
    }

}