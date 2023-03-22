package cz.mendelu.pef.cv1.ui.screens.taskList

import cz.mendelu.pef.cv1.model.Task

sealed class TaskListUIState { // trida reprezentujici stavy, kterych muze obrazovka nabyvat
    object Default : TaskListUIState() // odpocivej, inicializuj, zakladni stav
    class Success(val tasks: List<Task>) : TaskListUIState() // uspech; trida proto, ze ma params
    // tuto tridu viewmodel upravuje a ui nad nim posloucha, aby zobrazoval aktualni data
}
