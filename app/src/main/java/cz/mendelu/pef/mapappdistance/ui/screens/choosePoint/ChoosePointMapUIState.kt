package cz.mendelu.pef.mapappdistance.ui.screens.choosePoint

sealed class ChoosePointMapUIState {
    object Default : ChoosePointMapUIState() // odpocivej, inicializuj, zakladni stav

    object LocationChanged : ChoosePointMapUIState()
}