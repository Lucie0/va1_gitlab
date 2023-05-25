package cz.mendelu.pef.app_test_1.navigation

sealed class Destination(val route: String) {
    object CarListScreen: Destination(route = "car_list")
    object AddCarScreen: Destination(route = "add_car_list")
}