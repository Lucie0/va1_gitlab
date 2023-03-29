package cz.mendelu.pef.test1.ui.screens.addItem

sealed class AddItemUIState {
    object Default : AddItemUIState()
    object WordSaved : AddItemUIState()
}