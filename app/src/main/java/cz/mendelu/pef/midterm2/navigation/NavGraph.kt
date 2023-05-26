package cz.mendelu.pef.midterm2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cz.mendelu.pef.midterm2.ui.screens.AddPlayerScreen
import cz.mendelu.pef.midterm2.ui.screens.PlayerOnMatchScreen
import cz.mendelu.pef.midterm2.ui.screens.PlayersListScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),//aby si pamatoval, kde je
    navigation: INavigationRouter = remember {
        NavigationRouterImpl(navController)
    },
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Destination.PlayersListScreen.route) {
            PlayersListScreen(navigation) // zavolani jine composable fce a jen se zavola
        }

        composable(
            route = Destination.AddPlayerScreen.route + "/{id}", // receni, ze to bude paramter v ceste
            arguments = listOf(
                navArgument("id"){
                    type = NavType.LongType
                    defaultValue = -1L
                }
            )
        ) {
            val id = it.arguments?.getLong("id") // arg muze vracet null
            AddPlayerScreen(
                navigation,
                id = if (id != -1L) id else null
            )

        }

        composable(
            route = Destination.PlayerOnMatchScreen.route + "/{id}", // receni, ze to bude paramter v ceste
            arguments = listOf(
                navArgument("id"){
                    type = NavType.LongType
                    defaultValue = -1L
                }
            )
        ) {
            val id = it.arguments?.getLong("id") // arg muze vracet null
            PlayerOnMatchScreen(
                navigation,
                id = id!!
            )

        }


    }
}