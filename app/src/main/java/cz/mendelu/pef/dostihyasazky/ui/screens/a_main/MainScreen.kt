package cz.mendelu.pef.dostihyasazky.ui.screens.a_main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.dostihyasazky.R
import cz.mendelu.pef.dostihyasazky.architecture.BaseViewModel
import cz.mendelu.pef.dostihyasazky.navigation.INavigationRouter
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navigation: INavigationRouter,
    viewModel: MainScreenVM = getViewModel()
) {

    viewModel.uiState.value.let {
        when (it) {
            MainScreenUIState.Default -> {}

            MainScreenUIState.Loading -> {
                viewModel.initCardsToDB()
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.app_name))}, //"DOSTIHY A SÁZKY") },
            )
        }) {
        MainScreenContent(
            paddingValues = it,
            navigation = navigation,
            viewModel = viewModel
        )
    }
}

@Composable
fun MainScreenContent(
    paddingValues: PaddingValues,
    navigation: INavigationRouter,
    viewModel: MainScreenVM
) {

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.plan_svetly_1b_vyrez),
            contentDescription = null,
        )

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                viewModel.deleteNullSavedGameFromDB()
                navigation.navigateToGameScreen(-1L) }) {
                Text(stringResource(R.string.M_new_game))
            }

            Button(onClick = { navigation.navigateToSavedGamesScreen() }) {
                Text(stringResource(R.string.M_load_game))
            }

            Button(onClick = { navigation.navigateToSettingsScreen() }) {
                Text(stringResource(R.string.M_info))
            }
        }
    }
}