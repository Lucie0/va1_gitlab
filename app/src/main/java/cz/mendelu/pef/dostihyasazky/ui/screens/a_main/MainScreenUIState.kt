package cz.mendelu.pef.dostihyasazky.ui.screens.a_main

sealed class MainScreenUIState {
    object Default: MainScreenUIState()
    object Loading: MainScreenUIState()
//    object Success: MainScreenUIState()
}