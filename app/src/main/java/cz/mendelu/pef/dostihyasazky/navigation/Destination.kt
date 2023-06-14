package cz.mendelu.pef.dostihyasazky.navigation

sealed class Destination(val route: String) {
    object MainScreen: Destination(route = "main")
    object GameScreen: Destination(route = "game")
    object MyCardsScreen: Destination(route = "my_cards")
    object CardsDetailScreen: Destination(route = "card_detail")
    object RulesScreen: Destination(route = "rules")
    object SavedGamesListScreen: Destination(route = "saved_games")
    object SavedGameDetailScreen: Destination(route = "saved_game_detail")
    object TransactionsHistoryScreen: Destination(route = "transactions")
    object SettingsScreen: Destination(route = "settings")
}