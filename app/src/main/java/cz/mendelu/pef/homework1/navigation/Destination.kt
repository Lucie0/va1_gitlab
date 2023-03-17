package cz.mendelu.pef.homework1.navigation

sealed class Destination (val route: String) {
    object MainScreen : Destination(route = "main")
    object OperationScreen : Destination(route = "operation")
    object ResultScreen : Destination(route = "result")
}