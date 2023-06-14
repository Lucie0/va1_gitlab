package cz.mendelu.pef.dostihyasazky.ui.screens.my_cards

import cz.mendelu.pef.dostihyasazky.model.Card
import cz.mendelu.pef.dostihyasazky.model.CardWithMoreDetails

sealed class MyCardsUIState {
    object Default: MyCardsUIState()
    class Success(val items: List<CardWithMoreDetails>?): MyCardsUIState()
}