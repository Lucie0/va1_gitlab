package cz.mendelu.pef.dostihyasazky.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cz.mendelu.pef.dostihyasazky.ui.screens.*
import cz.mendelu.pef.dostihyasazky.ui.screens.game.GameScreen
import cz.mendelu.pef.dostihyasazky.ui.screens.a_main.MainScreen
import cz.mendelu.pef.dostihyasazky.ui.screens.card_detail.CardDetailScreen
import cz.mendelu.pef.dostihyasazky.ui.screens.my_cards.MyCardsScreen
import cz.mendelu.pef.dostihyasazky.ui.screens.saved_game_detail.SavedGameDetailScreen
import cz.mendelu.pef.dostihyasazky.ui.screens.saved_games_list.SavedGamesListScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),//aby si pamatoval, kde je
    navigation: INavigationRouter = remember { NavigationRouterImpl(navController) },
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Destination.MainScreen.route) {
            MainScreen(navigation) // zavolani jine composable fce a jen se zavola
        }
        composable(route = Destination.MyCardsScreen.route) {
            MyCardsScreen(navigation) // zavolani jine composable fce a jen se zavola
        }
        composable(route = Destination.RulesScreen.route) {
            RulesScreen(navigation) // zavolani jine composable fce a jen se zavola
        }
        composable(route = Destination.SavedGamesListScreen.route) {
            SavedGamesListScreen(navigation) // zavolani jine composable fce a jen se zavola
        }
        composable(route = Destination.TransactionsHistoryScreen.route) {
            TransactionsHistoryScreen(navigation) // zavolani jine composable fce a jen se zavola
        }

        composable(route = Destination.SettingsScreen.route) {
            SettingsScreen(navigation) // zavolani jine composable fce a jen se zavola
        }


        composable(
            route = Destination.GameScreen.route + "/{id}", // receni, ze to bude paramter v ceste
            arguments = listOf(
                navArgument("id") {
                    type = NavType.LongType
                    defaultValue = -1L
                }
            )
        ) {
            val id = it.arguments?.getLong("id")
            GameScreen(
                navigation = navigation,
                id = if (id != -1L) id else null
            )
        }

        composable(
            route = Destination.SavedGameDetailScreen.route + "/{id}", // receni, ze to bude paramter v ceste
            arguments = listOf(
                navArgument("id") {
                    type = NavType.LongType
                    defaultValue = -1L
                }
            )
        ) {
            val id = it.arguments?.getLong("id")
            SavedGameDetailScreen(
                navigation = navigation,
                id = if (id != -1L) id else null
            )
        }

        composable(
            route = Destination.CardsDetailScreen.route + "/{id}", // receni, ze to bude paramter v ceste
            arguments = listOf(
                navArgument("id") {
                    type = NavType.LongType
                    defaultValue = -1L
                }
            )
        ) {
            val id = it.arguments?.getLong("id")
            CardDetailScreen(
                navigation = navigation,
                id = if (id != -1L) id else null
            )
        }

//            arguments = listOf(
//                navArgument("id"){
//                    type = NavType.LongType
//                    defaultValue = -1L
//                }
//            )
//        ){
//            val id = it.arguments?.getLong("id") // arg muze vracet null
//            AddEditTaskScreen(
//                navigation = navigation,
//                id = if (id != -1L) id else null
//            )
    }

}

