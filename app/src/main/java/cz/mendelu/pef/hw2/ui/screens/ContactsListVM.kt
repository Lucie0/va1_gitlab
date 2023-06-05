package cz.mendelu.pef.hw2.ui.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cz.mendelu.pef.hw2.architecture.BaseViewModel
import cz.mendelu.pef.hw2.database.IRepository
import kotlinx.coroutines.launch

class ContactsListVM(private val repository: IRepository) : BaseViewModel() {

    var contactsListUIState: MutableState<ContactsListUIState> =
        mutableStateOf(ContactsListUIState.Default)

    fun load() {
        // poslech nad DB
        launch { // poslani na pozadi
            repository.getAll()
                .collect() { // poslouchej nad zmenami a sbirej, a kdyz se neco zmeni, vrat to -- v it
                    contactsListUIState.value = ContactsListUIState.Success(it) // zmen stav na "uspesne stazeni z db" a dej do ui list
                }
        }
    }
}