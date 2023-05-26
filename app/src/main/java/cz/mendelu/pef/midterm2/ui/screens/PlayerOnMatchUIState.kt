package cz.mendelu.pef.midterm2.ui.screens

import cz.mendelu.pef.midterm2.model.Player

sealed class PlayerOnMatchUIState {
    object Loading : PlayerOnMatchUIState()
    object Default : PlayerOnMatchUIState()
    object Saved : PlayerOnMatchUIState()
    object Changed : PlayerOnMatchUIState()
}