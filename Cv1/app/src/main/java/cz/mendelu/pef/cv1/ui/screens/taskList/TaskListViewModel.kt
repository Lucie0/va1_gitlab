package cz.mendelu.pef.cv1.ui.screens.taskList

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cz.mendelu.pef.cv1.architecture.BaseViewModel
import cz.mendelu.pef.cv1.database.ITasksRepository
import kotlinx.coroutines.launch

class TaskListViewModel(private val repository: ITasksRepository)
    : BaseViewModel(), TaskListActions {

//    fun insert(){
//        launch { repository.insert(Task("abc"))  } // launch -- neco volam na pozadi
//    }

        // promenna, vytvoreni zakladniho stavu
        // mutable state: nad nim posluchame a kdyz se neco zmeni, provede se
        val taskListUIState: MutableState<TaskListUIState> = mutableStateOf(TaskListUIState.Default)

    fun loadTasks(){
        // poslech nad DB
        launch { // poslani na pozadi
            repository.getAll()
                .collect() { // poslouchej nad zmenami a sbirej, a kdyz se neco zmeni, vrat to -- v it
                    taskListUIState.value =
                        TaskListUIState.Success(it) // zmen stav na "uspesne stazeni z db" a dej do ui list
                }
        }
    }

    override fun changeTaskState(id: Long, state: Boolean) {
        launch {
            repository.changeTaskState(id, state)
        }
    }
}