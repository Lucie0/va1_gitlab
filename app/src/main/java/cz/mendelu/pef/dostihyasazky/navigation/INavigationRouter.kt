package cz.mendelu.pef.dostihyasazky.navigation

import androidx.navigation.NavController

interface INavigationRouter {
    fun navigateBack()

    fun navigateToGameScreen(id: Long?)
    fun navigateToMyCardsScreen()
    fun navigateToCardDetailScreen(id: Long?)
    fun navigateToRulesScreen()
    fun navigateToSavedGamesScreen()
    fun navigateToTransactionsHistoryScreen()
    fun navigateToSettingsScreen()
    fun navigateToSavedGameDetailScreen(id: Long?)
    fun navigateToMapScreen(latitude: Double, longitude: Double)

    fun getNavController(): NavController

}