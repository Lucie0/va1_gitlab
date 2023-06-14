package cz.mendelu.pef.dostihyasazky.ui.screens.my_cards

import cz.mendelu.pef.dostihyasazky.model.Card

sealed class MyCardsUIState {
    object Default: MyCardsUIState()
    class Success(val items: List<Card?>): MyCardsUIState()
}