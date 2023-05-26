package cz.mendelu.pef.midterm2.navigation

sealed class Destination(val route: String) {
    object PlayersListScreen: Destination(route = "players_list")
    object AddPlayerScreen: Destination(route = "add_player")
    object PlayerOnMatchScreen: Destination(route = "player_on_match")
}