package cz.mendelu.pef.dostihyasazky.ui.screens.game

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cz.mendelu.pef.dostihyasazky.architecture.BaseViewModel
import kotlin.math.log

class GameScreenVM (
    // todo repository
    ) : BaseViewModel() {

//    var uiState: MutableState<GameScreenUIState> = mutableStateof(GameScreenUIState.Default)

    var diceNumber: Int = 0

    fun rollTheDice(){
        diceNumber = (Math.random() * 6).toInt() + 1
//        println(diceNumber)
    }

}