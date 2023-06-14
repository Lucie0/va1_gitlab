package cz.mendelu.pef.dostihyasazky.ui.screens.saved_game_detail

sealed class SavedGameDetailUIState {
    object Default: SavedGameDetailUIState()
    object Loading: SavedGameDetailUIState()
    object Changed: SavedGameDetailUIState()
    object Saved: SavedGameDetailUIState()
}