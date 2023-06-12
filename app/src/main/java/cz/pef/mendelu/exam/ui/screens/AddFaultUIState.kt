package cz.pef.mendelu.exam.ui.screens

sealed class AddFaultUIState {
    object Default : AddFaultUIState()
    object Saved : AddFaultUIState()
    object Changed : AddFaultUIState()
}