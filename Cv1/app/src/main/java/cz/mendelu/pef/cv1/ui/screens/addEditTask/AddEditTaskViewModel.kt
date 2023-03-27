package cz.mendelu.pef.cv1.ui.screens.addEditTask

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cz.mendelu.pef.cv1.architecture.BaseViewModel
import cz.mendelu.pef.cv1.database.ITasksRepository
import cz.mendelu.pef.cv1.model.Task
import kotlinx.coroutines.launch

class AddEditTaskViewModel(private val repository: ITasksRepository)
    : BaseViewModel(), AddEditTaskActions {
    // vyuziti dependency injection -- private val repository
    val addEditTaskUIState: MutableState<AddEditTaskUIState> = mutableStateOf(AddEditTaskUIState.Default)

    override fun saveTask() {
            launch {
                val id = repository.insert(Task(System.currentTimeMillis().toString())) // casove indexy
                if (id > 0){
                    addEditTaskUIState.value = AddEditTaskUIState.TaskSaved
                } else {
                    // todo error, napr. ze neulozeno
                }
            }
    }
}