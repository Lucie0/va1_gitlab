package cz.mendelu.pef.midterm2.ui.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cz.mendelu.pef.midterm2.architecture.BaseViewModel
import cz.mendelu.pef.midterm2.database.IRepository
import kotlinx.coroutines.launch

class PlayersListVM(private val repository: IRepository) : BaseViewModel() {

    var playersListUIState: MutableState<PlayersListUIState> = mutableStateOf(PlayersListUIState.Default)

    fun load() {
        // poslech nad DB
        launch {
            // poslani na pozadi
            repository.getAll()
                .collect() {
                    playersListUIState.value = PlayersListUIState.Success(it)
                }
        }
    }
}
