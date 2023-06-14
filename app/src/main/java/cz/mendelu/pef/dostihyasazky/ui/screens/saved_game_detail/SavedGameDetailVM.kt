package cz.mendelu.pef.dostihyasazky.ui.screens.saved_game_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cz.mendelu.pef.dostihyasazky.architecture.BaseViewModel
import cz.mendelu.pef.dostihyasazky.database.IRacesBetsRepository
import cz.mendelu.pef.dostihyasazky.model.SavedGame
import kotlinx.coroutines.launch

class SavedGameDetailVM(private val repository: IRacesBetsRepository) : BaseViewModel() {
    var uiState: MutableState<SavedGameDetailUIState> = mutableStateOf(SavedGameDetailUIState.Loading)
    var data: SavedGame = SavedGame("", 0)
    var savedGameId: Long? = null

    fun initSavedGame() {
        if (savedGameId != null) {
            launch {
                // ziskani tasku
                data = repository.getSavedGameById(savedGameId!!)
                // hlaska o zmene stavu
                uiState.value = SavedGameDetailUIState.Changed
            }
        } else {
            // nacitani
            // hlaska o zmene stavu
            uiState.value = SavedGameDetailUIState.Changed
        }
    }

    fun onNameChange(value: String) {
        data.name = value
        uiState.value = SavedGameDetailUIState.Changed
    }

    fun onNotesChanges(value: String) {
        data.notes = value
        uiState.value = SavedGameDetailUIState.Changed
    }

    fun updateGame(){
        launch {
            repository.updateSavedGame(data)
            uiState.value = SavedGameDetailUIState.Saved
        }
    }

    fun deleteGame(){
        launch {
            repository.deleteSavedGame(data)
            uiState.value = SavedGameDetailUIState.Deleted
        }
    }
}