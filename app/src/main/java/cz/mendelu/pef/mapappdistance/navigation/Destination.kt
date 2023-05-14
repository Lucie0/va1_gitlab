package cz.mendelu.pef.mapappdistance.navigation

sealed class Destination (val route: String) { // trida, ktera v sobe obsahuje dalsi tridy, je to vyctovy typ trid, obdoba predka a potomku
    object ChoosePointMapScreen : Destination(route = "choose_point")
    object ShowDistanceMapScreen : Destination(route = "show_distance")
}