package cz.mendelu.pef.dostihyasazky.ui.screens.saved_games_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cz.mendelu.pef.dostihyasazky.architecture.BaseViewModel
import cz.mendelu.pef.dostihyasazky.database.IRacesBetsRepository
import kotlinx.coroutines.launch

class SavedGamesListVM(private val repository: IRacesBetsRepository) : BaseViewModel() {
    var uiState: MutableState<SavedGamesListUIState> = mutableStateOf(SavedGamesListUIState.Default)

    fun loadSavedGames() {
        launch {
            repository.getAllSavedGames()
                .collect() { // poslouchej nad zmenami a sbirej, a kdyz se neco zmeni, vrat to -- v it
                    uiState.value = SavedGamesListUIState.Success(it)
                }
        }
    }
}