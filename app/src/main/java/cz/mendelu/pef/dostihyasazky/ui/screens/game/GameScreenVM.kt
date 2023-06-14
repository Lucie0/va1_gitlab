package cz.mendelu.pef.dostihyasazky.ui.screens.game

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cz.mendelu.pef.dostihyasazky.architecture.BaseViewModel
import cz.mendelu.pef.dostihyasazky.ui.elements.MyBox

class GameScreenVM(
    // todo repository
) : BaseViewModel() {

    var uiState: MutableState<GameScreenUIState> = mutableStateOf(GameScreenUIState.Default)

    var boxesArray = ArrayList<MyBox>()
    var diceNumber: Int = 0

    var firstRun = true //Datastore get("firstrun")

    fun rollTheDice() {
        diceNumber = (Math.random() * 6).toInt() + 1
        uiState.value = GameScreenUIState.Changed
//        println(diceNumber)
    }

    fun initBoxesArray() {
        boxesArray.add(MyBox(1, 10, 10, "Start"))
        boxesArray.add(MyBox(2, 10, 10, "Fantome"))
        boxesArray.add(MyBox(3, 10, 10, "Finance"))
        boxesArray.add(MyBox(4, 10, 10, "Gavora"))
        boxesArray.add(MyBox(5, 10, 10, "Klinika 1"))
        boxesArray.add(MyBox(6, 10, 10, "Trenér 1"))
        boxesArray.add(MyBox(7, 10, 10, "Lady Anne"))
        boxesArray.add(MyBox(8, 10, 10, "Náhoda"))
        boxesArray.add(MyBox(9, 10, 10, "Pasek"))
        boxesArray.add(MyBox(10, 10, 10, "Koran"))
        boxesArray.add(MyBox(11, 10, 10, "Distance"))
        boxesArray.add(MyBox(12, 10, 10, "Neklan"))
        boxesArray.add(MyBox(13, 10, 10, "Přeprava"))
        boxesArray.add(MyBox(14, 10, 10, "Portlanc"))
        boxesArray.add(MyBox(15, 10, 10, "Japan"))
        boxesArray.add(MyBox(16, 10, 10, "Trenér 2"))
        boxesArray.add(MyBox(17, 10, 10, "Kostrava"))
//        tady finance, uz zapsany
        boxesArray.add(MyBox(18, 10, 10, "Lukava"))
        boxesArray.add(MyBox(19, 10, 10, "Melák"))
        boxesArray.add(MyBox(20, 10, 10, "Parkoviště"))
        boxesArray.add(MyBox(21, 10, 10, "Grifel"))
//        nahoda
        boxesArray.add(MyBox(23, 10, 10, "Mohyla"))
        boxesArray.add(MyBox(24, 10, 10, "Metál"))
        boxesArray.add(MyBox(25, 10, 10, "Trenér 3"))
        boxesArray.add(MyBox(26, 10, 10, "Tara"))
        boxesArray.add(MyBox(27, 10, 10, "Furioso"))
        boxesArray.add(MyBox(28, 10, 10, "Stáje"))
        boxesArray.add(MyBox(29, 10, 10, "Génius"))
        boxesArray.add(MyBox(30, 10, 10, "Podezření z dopingu"))
        boxesArray.add(MyBox(31, 10, 10, "Shagga"))
        boxesArray.add(MyBox(32, 10, 10, "Dahoman"))
//        finance
        boxesArray.add(MyBox(33, 10, 10, "Gira"))
        boxesArray.add(MyBox(34, 10, 10, "Trenér 4"))
//        nahoda
        boxesArray.add(MyBox(35, 10, 10, "Narcius"))
        boxesArray.add(MyBox(36, 10, 10, "Klinika 2"))
        boxesArray.add(MyBox(37, 10, 10, "Napoli"))
    }


    fun  alreadyFirstRun(){
        // todo datastore. firstRun nastavit na FALSE
        firstRun = false // todo delete
    }

    fun saveGame(){
        //todo db -> save game
        uiState.value = GameScreenUIState.Saved
    }

}