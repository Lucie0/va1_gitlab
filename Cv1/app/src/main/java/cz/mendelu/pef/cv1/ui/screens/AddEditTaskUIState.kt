package cz.mendelu.pef.cv1.ui.screens

sealed class AddEditTaskUIState{
    object Default : AddEditTaskUIState()
    object TaskSaved : AddEditTaskUIState()

}
