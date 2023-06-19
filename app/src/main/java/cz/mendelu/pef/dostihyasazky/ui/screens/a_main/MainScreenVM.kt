package cz.mendelu.pef.dostihyasazky.ui.screens.a_main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cz.mendelu.pef.dostihyasazky.R
import cz.mendelu.pef.dostihyasazky.architecture.BaseViewModel
import cz.mendelu.pef.dostihyasazky.database.IRacesBetsRepository
import cz.mendelu.pef.dostihyasazky.model.Card
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainScreenVM(private val repository: IRacesBetsRepository) : BaseViewModel() {

    var uiState: MutableState<MainScreenUIState> = mutableStateOf(MainScreenUIState.Loading)
    lateinit var cards: Flow<List<Card>>

    fun initCardsToDB() {
//        launch {
//            cards = repository.getAllCards()
//
//            cards.collect{list ->
//                list.forEach{
//                    repository.deleteCard(it)
//                }
//
//            }

//        insertCard(
//            Card(
//                name = "Start",
//                image = 0,
//                historicalCost = 0,
//                fixFee = -4000,
//                paymentTypeID = 1,
//                cardTypeID = 3,
//                moreDetailsID = 1
//            )
//        )
//        insertCard(
//            Card(
//                name = "Fantome",
//                image = R.drawable.shagya1,
//                historicalCost = 1200,
//                fixFee = -4000,
//                paymentType = "ownership",
//                cardType = "horse",
//            )
//        )
//        println(":)" + R.drawable.appaloosa_hneda8)
        uiState.value = MainScreenUIState.Default
//        }
    }

    fun insertCard(card: Card) {
        launch {
            repository.insertCard(card)
        }
    }

    fun deleteNullSavedGameFromDB(){
        launch {
            repository.deleteNullSavedGame()
        }
    }

}