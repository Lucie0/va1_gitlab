package cz.mendelu.pef.dostihyasazky.ui.screens.my_cards

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cz.mendelu.pef.dostihyasazky.architecture.BaseViewModel
import cz.mendelu.pef.dostihyasazky.database.IRacesBetsRepository
import kotlinx.coroutines.launch

class MyCardsVM(private val repository: IRacesBetsRepository) : BaseViewModel() {

    var uiState: MutableState<MyCardsUIState> = mutableStateOf(MyCardsUIState.Default)

    var loadedGameId: Long? = -1L
    var playerId: Long = -1L

    fun loadMyCards() {
        launch {
            if (loadedGameId != -1L && loadedGameId != null) {
                repository.getSavedGameToCardWithSavedGameWithCardWMoreDetailsByOwnerAndGameId(
                    playerId,
                    loadedGameId!!
                )
            } else {
                repository.getSavedGameToCardWithSavedGameWithCardWMoreDetailsByOwnerAndNullGameId(
                    playerId
                )
            }
                .collect() {
                    uiState.value = MyCardsUIState.Success(it)
                }
        }

    }
}