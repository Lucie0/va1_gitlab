package cz.mendelu.pef.dostihyasazky.ui.screens.my_cards

import cz.mendelu.pef.dostihyasazky.architecture.BaseViewModel
import cz.mendelu.pef.dostihyasazky.database.IRacesBetsRepository

class MyCardsVM (private val repository: IRacesBetsRepository) : BaseViewModel() {

    fun loadMyCards(id: Int){
//        launch{
//            repository.getMyCards(playerID = id)
    //            repository.getAll()
//                .collect() { // poslouchej nad zmenami a sbirej, a kdyz se neco zmeni, vrat to -- v it
//                    contactsListUIState.value = ContactsListUIState.Success(it)
//
//        }
    }

}