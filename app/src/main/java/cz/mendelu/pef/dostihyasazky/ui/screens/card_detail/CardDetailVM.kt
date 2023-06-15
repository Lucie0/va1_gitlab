package cz.mendelu.pef.dostihyasazky.ui.screens.card_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cz.mendelu.pef.dostihyasazky.architecture.BaseViewModel
import cz.mendelu.pef.dostihyasazky.database.IRacesBetsRepository
import cz.mendelu.pef.dostihyasazky.model.Card
import cz.mendelu.pef.dostihyasazky.model.CardWithMoreDetails
import cz.mendelu.pef.dostihyasazky.model.MoreDetails
import kotlinx.coroutines.launch

class CardDetailVM(private val repository: IRacesBetsRepository) : BaseViewModel() {
    var uiState: MutableState<CardDetailUIState> = mutableStateOf(CardDetailUIState.Loading)

    var data: CardWithMoreDetails =
        CardWithMoreDetails(
            card = Card("", 0, 0, 0, 0, 0),
            moreDetails = MoreDetails("", 0, 0, 0)
        )

    var loadCardId: Long? = null

    fun initCard() {
        if (loadCardId != null) {
            launch {
                data = repository.getCardWithMoreDetailsByCardId(loadCardId!!)!!
                uiState.value = CardDetailUIState.Changed
            }
        } else {
            uiState.value = CardDetailUIState.Changed
        }
    }

    fun buyRace(){
        if (data.moreDetails.raceCount < 5){
            data.moreDetails.raceCount += 1
            launch {
                repository.updateCard(data.card)
                repository.updateMoreDetails(data.moreDetails)
                uiState.value = CardDetailUIState.Updated
            }
        } else {
            uiState.value = CardDetailUIState.CannotBuyRace
        }
    }

}