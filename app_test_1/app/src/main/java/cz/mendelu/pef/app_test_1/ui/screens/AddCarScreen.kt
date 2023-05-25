package cz.mendelu.pef.app_test_1.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import cz.mendelu.pef.app_test_1.model.Car
import cz.mendelu.pef.app_test_1.navigation.INavigationRouter
import cz.mendelu.pef.app_test_1.ui.elements.BackArrowScreen
import cz.mendelu.pef.app_test_1.ui.elements.MyTextField
import org.koin.androidx.compose.getViewModel

@Composable
fun AddCarScreen(
    navigation: INavigationRouter,
    viewModel: AddCarVM = getViewModel()
) {

    // ----------------------------
    // ukladani dat z VM a pamatovani i po rekompozici
    var data: Car by remember {
        mutableStateOf(viewModel.dataCar)
    }
    // ----------------------------

    // ----------------------------
    // rekompozice ui pri zmene
    viewModel.addCarUIState.value.let {
        when(it){
            AddCarUIState.Default -> {

            }

            AddCarUIState.Changed -> {
                data = viewModel.dataCar
                viewModel.addCarUIState.value = AddCarUIState.Default
            }

            AddCarUIState.Loading -> {
                viewModel.initItems()
            }

            AddCarUIState.Saved -> {
                LaunchedEffect(it) {
                    navigation.navigateBack()
                }
            }
        }
    }
    // ----------------------------

    // ----------------------------
    //samotna obrazovka
    BackArrowScreen(
        appBarTitle = "Add Car",
        onBackClick = {
            navigation.navigateBack()
        }
    ) {
        AddCarScreenContent(
            paddingValues = it,
            viewModel = viewModel
        )
    }
    // ----------------------------
}

@Composable
fun AddCarScreenContent(
    paddingValues: PaddingValues,
    viewModel: AddCarVM
) {

    // ----------------------------
    // policko s SPZ
    MyTextField(
        value = viewModel.dataCar.spz,
        hint = "SPZ",
        onValueChange = {
            viewModel.onValueChange(it)
        },
        error = "",
        paddingValues = paddingValues
    )
    // ----------------------------

    // ----------------------------
    // tlacitko SAVE
    OutlinedButton(onClick = {
        viewModel.save()
    }) {
        Text("Save")
    }
    // ----------------------------

}