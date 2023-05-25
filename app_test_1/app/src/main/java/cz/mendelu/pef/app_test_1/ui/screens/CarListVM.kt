package cz.mendelu.pef.app_test_1.ui.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cz.mendelu.pef.app_test_1.architecture.BaseViewModel
import cz.mendelu.pef.app_test_1.database.IRepository
import kotlinx.coroutines.launch

class CarListVM(private val repository: IRepository) : BaseViewModel() {

    var carListUIState: MutableState<CarListUIState> = mutableStateOf(CarListUIState.Default)

    // ----------------------------
    // prvotni poslech nad DB
    fun load() {
        // poslech nad DB
        launch { // poslani na pozadi
            repository.getAll()
                .collect() { // poslouchej nad zmenami a sbirej, a kdyz se neco zmeni, vrat to -- v it
                    carListUIState.value = CarListUIState.Success(it) // zmen stav na "uspesne stazeni z db" a dej do ui list
                }
        }
    }
    // ----------------------------

}