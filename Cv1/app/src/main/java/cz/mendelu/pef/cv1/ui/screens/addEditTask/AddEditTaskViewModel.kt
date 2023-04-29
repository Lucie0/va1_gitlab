package cz.mendelu.pef.cv1.ui.screens.addEditTask

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cz.mendelu.pef.cv1.R
import cz.mendelu.pef.cv1.architecture.BaseViewModel
import cz.mendelu.pef.cv1.database.ITasksRepository
import cz.mendelu.pef.cv1.model.Task
import kotlinx.coroutines.launch

class AddEditTaskViewModel(private val repository: ITasksRepository) : BaseViewModel(),
    AddEditTaskActions {
    // vyuziti dependency injection -- private val repository
    var addEditTaskUIState: MutableState<AddEditTaskUIState> =
        mutableStateOf(AddEditTaskUIState.Loading)

    var data: AddEditScreenData = AddEditScreenData() // udrzujeme si data ve VM
    var taskId: Long? = null // ukladame si id ukolu pro rozpoznani, jestli vkladame nebo upravujeme

    override fun saveTask() {
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

    override fun onTextChange(text: String) {
        data.task.text = text
        addEditTaskUIState.value = AddEditTaskUIState.TaskChanged
    }

    fun initTask() {
        if (taskId != null) {
            launch {
                // ziskani tasku
                data.task = repository.getTaskById(taskId!!)
                // nacitani
                data.loading = false
                // hlaska o zmene stavu
                addEditTaskUIState.value = AddEditTaskUIState.TaskChanged
            }
        } else {
            // nacitani
            data.loading = false
            // hlaska o zmene stavu
            addEditTaskUIState.value = AddEditTaskUIState.TaskChanged
        }
        // nedavat neco mimo vlakno lauch, jinak se bude hlasit driv, ze je vse OK, a ono to pritom bude porbihat ve vlakne na pozadi

    }
}