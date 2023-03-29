package cz.mendelu.pef.test1.navigation

sealed class Destination (val route: String) {
    object AddItemScreen : Destination(route = "add_item")
    object ListOfWordsScreen : Destination(route = "list_of_words")
    object MainScreen : Destination(route = "main_screen")
}