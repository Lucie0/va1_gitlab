package cz.mendelu.pef.hw2.ui.screens

sealed class AddContactUIState{
    object Loading : AddContactUIState()
    object Default : AddContactUIState()
    object Saved : AddContactUIState()
    object Changed : AddContactUIState()
}