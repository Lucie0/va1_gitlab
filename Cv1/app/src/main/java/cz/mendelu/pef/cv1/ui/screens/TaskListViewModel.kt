package cz.mendelu.pef.cv1.ui.screens

import cz.mendelu.pef.cv1.architecture.BaseViewModel
import cz.mendelu.pef.cv1.database.ITasksRepository
import cz.mendelu.pef.cv1.model.Task
import kotlinx.coroutines.launch

class TaskListViewModel(private val repository: ITasksRepository)
    : BaseViewModel() {

    fun insert(){
        launch { repository.insert(Task("abc"))  } // launch -- neco volam na pozadi
    }
}