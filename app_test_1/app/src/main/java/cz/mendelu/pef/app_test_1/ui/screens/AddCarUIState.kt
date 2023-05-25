package cz.mendelu.pef.app_test_1.ui.screens

sealed class AddCarUIState{
    object Loading : AddCarUIState()
    object Default : AddCarUIState()
    object Saved : AddCarUIState()
    object Changed : AddCarUIState()

}
