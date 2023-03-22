package cz.mendelu.pef.cv1.ui.screens.taskList

interface TaskListActions {
    fun changeTaskState(id: Long, state: Boolean)
}