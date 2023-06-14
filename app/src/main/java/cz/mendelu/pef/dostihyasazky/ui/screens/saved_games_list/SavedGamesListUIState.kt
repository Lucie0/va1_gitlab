package cz.mendelu.pef.dostihyasazky.ui.screens.saved_games_list

import cz.mendelu.pef.dostihyasazky.model.SavedGame

sealed class SavedGamesListUIState {
    object Default: SavedGamesListUIState()
    class Success(val items: List<SavedGame>?):  SavedGamesListUIState()

}