package cz.mendelu.pef.dostihyasazky.navigation

import androidx.navigation.NavController
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import cz.mendelu.pef.dostihyasazky.model.json.Location
import cz.mendelu.pef.dostihyasazky.model.json.ParametersForMyCards

class NavigationRouterImpl(private val navController: NavController) : INavigationRouter {

    override fun getNavController(): NavController = navController

    override fun navigateBack() {
        navController.popBackStack()
    }

    override fun navigateToGameScreen(id: Long?) {
        navController.navigate(Destination.GameScreen.route + "/" + id)
    }

    override fun navigateToMyCardsScreen(playerId: Long, gameId: Long?) {
        println(":)" + playerId + gameId)
//        if (gameId != null) {
            val moshi: Moshi = Moshi.Builder().build()
            // jaka trida se bude prevadet
            val jsonAdapter: JsonAdapter<ParametersForMyCards> =
                moshi.adapter(ParametersForMyCards::class.java)

            val jsonString = jsonAdapter.toJson(
                ParametersForMyCards(
                    gameId = gameId ?: -1,
                    playerId = playerId
                )
            )
            navController.navigate(Destination.MyCardsScreen.route + "/" + jsonString)
//        } else {
//            navController.navigate(Destination.MyCardsScreen.route + "/" + playerId)
//        }
    }

    override fun navigateToCardDetailScreen(id: Long?) {
        navController.navigate(Destination.CardsDetailScreen.route + "/" + id)
    }

    override fun navigateToRulesScreen() {
        navController.navigate(Destination.RulesScreen.route)
    }

    override fun navigateToSavedGamesScreen() {
        navController.navigate(Destination.SavedGamesListScreen.route)
    }

    override fun navigateToTransactionsHistoryScreen() {
        navController.navigate(Destination.TransactionsHistoryScreen.route)
    }

    override fun navigateToSettingsScreen() {
        navController.navigate(Destination.SettingsScreen.route)
    }

    override fun navigateToSavedGameDetailScreen(id: Long?) {
        navController.navigate(Destination.SavedGameDetailScreen.route + "/" + id)
    }

    override fun navigateToMapScreen(latitude: Double, longitude: Double) {
        // serializace na json
        val moshi: Moshi = Moshi.Builder().build()
        // jaka trida se bude prevadet
        val jsonAdapter: JsonAdapter<Location> = moshi.adapter(Location::class.java)

        val jsonString = jsonAdapter.toJson(
            Location(
                latitude = latitude,
                longitude = longitude
            )
        )

        navController.navigate(Destination.MapScreen.route + "/" + jsonString)
    }

//    override fun navigateToAddAccountScreen(id: Long?) {
//        navController.navigate(Destination.AddAccountScreen.route + "/" + id)
//    }

}