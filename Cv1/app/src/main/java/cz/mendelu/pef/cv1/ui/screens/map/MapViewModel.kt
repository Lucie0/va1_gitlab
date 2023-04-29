package cz.mendelu.pef.cv1.ui.screens.map

import cz.mendelu.pef.cv1.architecture.BaseViewModel
import cz.mendelu.pef.cv1.database.ITasksRepository
import cz.mendelu.pef.cv1.ui.screens.addEditTask.AddEditTaskActions


class MapViewModel(private val repository: ITasksRepository)
    : BaseViewModel(), AddEditTaskActions {

    override fun saveTask() {
        TODO("Not yet implemented")
    }

    override fun onTextChange(text: String) {
        TODO("Not yet implemented")
    }

    override fun onDateChange(date: Long?) {
        TODO("Not yet implemented")
    }


}