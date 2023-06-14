package cz.mendelu.pef.dostihyasazky.ui.screens.my_cards

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cz.mendelu.pef.dostihyasazky.architecture.BaseViewModel
import cz.mendelu.pef.dostihyasazky.database.IRacesBetsRepository
import kotlinx.coroutines.launch

class MyCardsVM(private val repository: IRacesBetsRepository) : BaseViewModel() {

    var uiState: MutableState<MyCardsUIState> = mutableStateOf(MyCardsUIState.Default)

    fun loadMyCards(id: Long) {
        launch {
            repository.getCardWithMoreDetails(id)
                .collect() { // poslouchej nad zmenami a sbirej, a kdyz se neco zmeni, vrat to -- v it
                    uiState.value = MyCardsUIState.Success(it)
                }
        }

    }
}