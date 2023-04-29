package cz.mendelu.pef.cv1.navigation

sealed class Destination (val route: String) { // trida, ktera v sobe obsahuje dalsi tridy, je to vyctovy typ trid, obdoba predka a potomku
    // kdyz je to val, tak je to atribut tridy
    object TaskListScreen : Destination(route = "task_list")
    object AddEditTaskScreen : Destination(route = "add_edit_task")
    object MapScreen : Destination(route = "map")
}
