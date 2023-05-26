package cz.mendelu.pef.midterm2.ui.screens

import cz.mendelu.pef.midterm2.model.Player as Item


sealed class PlayersListUIState {
    object Default: PlayersListUIState()
    class Success(val items: List<Item>): PlayersListUIState()
}