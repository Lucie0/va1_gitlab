package cz.pef.mendelu.exam.navigation

sealed class Destination(val route: String){
    object FaultsListScreen: Destination(route = "faults_list")
    object AddFaultScreen: Destination(route = "add_fault")

}
