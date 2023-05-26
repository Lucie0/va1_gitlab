package cz.mendelu.pef.midterm2.ui.screens

sealed class AddPlayerUIState{
    object Loading : AddPlayerUIState()
    object Default : AddPlayerUIState()
    object Saved : AddPlayerUIState()
    object Changed : AddPlayerUIState()
}