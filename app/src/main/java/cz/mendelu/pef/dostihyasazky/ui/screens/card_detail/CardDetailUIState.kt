package cz.mendelu.pef.dostihyasazky.ui.screens.card_detail

sealed class CardDetailUIState {
    object Default: CardDetailUIState()
    object Loading: CardDetailUIState()
    object Changed: CardDetailUIState()
    object Updated: CardDetailUIState()
    object CannotBuyRace: CardDetailUIState()
}