package cz.pef.mendelu.exam.ui.screens

import cz.pef.mendelu.exam.model.Fault

sealed class FaultsListUIState {
    object Default: FaultsListUIState()
    class Success(val items: List<Fault>): FaultsListUIState()
}