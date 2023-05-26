package cz.mendelu.pef.midterm2.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import cz.mendelu.pef.midterm2.model.Player
import cz.mendelu.pef.midterm2.navigation.INavigationRouter
import cz.mendelu.pef.midterm2.ui.elements.BackArrowScreen
import cz.mendelu.pef.midterm2.ui.elements.MyTextField
import org.koin.androidx.compose.getViewModel

@Composable
fun AddPlayerScreen(
    navigation: INavigationRouter,
    id: Long?,
    viewModel: AddPlayerVM = getViewModel()
) {

    var data: Player by remember {
        mutableStateOf(viewModel.dataPlayer)
    }

    viewModel.addPlayerUIState.value.let {
        when(it){
            AddPlayerUIState.Default -> { }
            AddPlayerUIState.Changed -> {
                data = viewModel.dataPlayer
                viewModel.addPlayerUIState.value = AddPlayerUIState.Default
            }

            AddPlayerUIState.Loading -> {
                 viewModel.initItem()
            }
            AddPlayerUIState.Saved -> {
                LaunchedEffect(it) {
                    navigation.navigateBack()
                }
            }
        }
    }

    BackArrowScreen(
        appBarTitle = "Add Player",
        onBackClick = {
            navigation.navigateBack()
    }) {
        AddPlayerScreenContent(
            paddingValues = it,
            viewModel = viewModel
        )
    }

}

@Composable
fun AddPlayerScreenContent(
    paddingValues: PaddingValues,
    viewModel: AddPlayerVM
) {

    MyTextField(
        value = viewModel.dataPlayer.name,
        hint = "First and last name",
        onValueChange = {
            viewModel.onValueChange(it)
        },
        error = ""
    )

    OutlinedButton(onClick = {
        viewModel.save()
    }) {
        Text(text = "Save")
    }
}