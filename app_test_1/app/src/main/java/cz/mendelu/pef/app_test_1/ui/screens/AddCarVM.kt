package cz.mendelu.pef.app_test_1.ui.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cz.mendelu.pef.app_test_1.architecture.BaseViewModel
import cz.mendelu.pef.app_test_1.database.IRepository
import cz.mendelu.pef.app_test_1.model.Car
import kotlinx.coroutines.launch

class AddCarVM(private val repository: IRepository) : BaseViewModel() {

    var dataCar: Car = Car("")

    var addCarUIState: MutableState<AddCarUIState> =
        mutableStateOf(AddCarUIState.Loading)

    // ----------------------------
    // UKLADANI
    fun save() {
        if (dataCar.spz.isEmpty()) {
            // todo error IsEmpty
//            println("data SPZ is empty")
            addCarUIState.value = AddCarUIState.Changed
        } else {
//            println("SAVING>>>")
            launch {
                repository.insert(dataCar)
                addCarUIState.value = AddCarUIState.Saved
            }
        }
    }
    // ----------------------------

    // ----------------------------
    // zmena hodnoty
    fun onValueChange(spz: String){
        dataCar.spz = spz
        addCarUIState.value = AddCarUIState.Changed
        println("$spz == ${dataCar.spz}")
    }
    // ----------------------------


    // ----------------------------
    // pro editovani itemu
    fun initItems(){
        if(dataCar.id != null){
            launch {
                // ziskani tasku
                dataCar = repository.getItemById(dataCar.id!!)
                // hlaska o zmene stavu
                addCarUIState.value = AddCarUIState.Changed
            }
        } else {
            // hlaska o zmene stavu
            addCarUIState.value = AddCarUIState.Changed
        }
        // nedavat neco mimo vlakno lauch, jinak se bude hlasit driv, ze je vse OK, a ono to pritom bude porbihat ve vlakne na pozadi
    }
    // ----------------------------

}

/*
//        override fun saveTask() {
if (data.task.text.isEmpty()) {
    // pokud je text prazdny, vyvolej error
    data.taskTextError = R.string.cannot_be_empty // R je staticka trida, zusit volani contextu, nepotrebujeme ho
    addEditTaskUIState.value = AddEditTaskUIState.TaskChanged
} else {
    launch {
        if (taskId == null) {
            val id =
                repository.insert(data.task) //Task(System.currentTimeMillis().toString())) // casove indexy
            if (id > 0) {
                addEditTaskUIState.value = AddEditTaskUIState.TaskSaved
            } else {
                // todo error, napr. ze neulozeno
//                        data.taskTextError = "Some error, task not save"
            }
        } else {
            // repository.updateTask(data.task.id, data.task.text) // NEFUGOVALO
            val updated = repository.update(data.task)
//                    if (updated == 1) { // neni nyni nutne, hodi se u seznamu
            addEditTaskUIState.value = AddEditTaskUIState.TaskSaved
//                    } else {
            // todo error, napr. ze se nepodarilo updatovat
//                    }
        }
    }
}
}
*/