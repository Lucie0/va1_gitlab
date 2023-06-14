package cz.mendelu.pef.dostihyasazky.ui.screens.game

sealed class GameScreenUIState {
    object Default : GameScreenUIState()
    object Loading : GameScreenUIState()
    object Changed : GameScreenUIState()
    object Saved : GameScreenUIState()
}