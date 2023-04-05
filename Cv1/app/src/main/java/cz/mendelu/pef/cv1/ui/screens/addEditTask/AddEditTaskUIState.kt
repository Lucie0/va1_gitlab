package cz.mendelu.pef.cv1.ui.screens.addEditTask

sealed class AddEditTaskUIState{
    object Loading : AddEditTaskUIState()
    object Default : AddEditTaskUIState()
    object TaskSaved : AddEditTaskUIState()
    object TaskChanged : AddEditTaskUIState()

}
