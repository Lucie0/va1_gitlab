package cz.mendelu.pef.midterm2.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.room.util.getColumnIndex
import cz.mendelu.pef.midterm2.architecture.BaseViewModel
import cz.mendelu.pef.midterm2.navigation.Destination
import cz.mendelu.pef.midterm2.navigation.INavigationRouter
import cz.mendelu.pef.midterm2.ui.elements.BackArrowScreen
import org.koin.androidx.compose.getViewModel

@Composable
fun PlayerOnMatchScreen(
    navigation: INavigationRouter,
    id: Long,
    viewModel: PlayerOnMatchVM = getViewModel(),
    ){

//    var player = viewModel.getPlayerById()

    viewModel.playerOnMatchUIState.value.let {
        when(it){
            PlayerOnMatchUIState.Default -> {}
            PlayerOnMatchUIState.Changed -> {
                viewModel.playerOnMatchUIState.value = PlayerOnMatchUIState.Default
            }
            PlayerOnMatchUIState.Loading -> {

            }
            PlayerOnMatchUIState.Saved -> {
                LaunchedEffect(it) {
                    navigation.navigateBack()
                }
            }
        }
    }

    BackArrowScreen(appBarTitle = "Player on Match", onBackClick = {
        navigation.navigateBack()
    }) {
        PlayerOnMatchScreenContent(it,
        viewModel = viewModel,
        id = id)

    }}

@Composable
fun PlayerOnMatchScreenContent(
    paddingValues: PaddingValues,
    viewModel: PlayerOnMatchVM,
    id: Long
){

    OutlinedButton(onClick = {
        // vm.callon match
        viewModel.onChangeState(id, state = true)
    }) {
        Text(text = "Player was on match")
    }

}