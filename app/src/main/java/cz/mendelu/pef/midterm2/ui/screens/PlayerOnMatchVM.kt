package cz.mendelu.pef.midterm2.ui.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cz.mendelu.pef.midterm2.architecture.BaseViewModel
import cz.mendelu.pef.midterm2.database.IRepository
import cz.mendelu.pef.midterm2.model.Player
import kotlinx.coroutines.launch

class PlayerOnMatchVM (private val repository: IRepository) : BaseViewModel() {

    var playerOnMatchUIState: MutableState<PlayerOnMatchUIState> = mutableStateOf(PlayerOnMatchUIState.Default)

    fun onChangeState(id: Long, state: Boolean) {
        launch {
            repository.changeState(id, state)
            playerOnMatchUIState.value = PlayerOnMatchUIState.Saved
        }
    }

    suspend fun getPlayerById(id: Long): Player {
        return repository.getItemById(id)
    }

}