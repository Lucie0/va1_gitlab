package cz.pef.mendelu.exam.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cz.pef.mendelu.exam.ui.screens.AddFaultScreen
import cz.pef.mendelu.exam.ui.screens.FaultsListScreen


@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    navigation: INavigationRouter = remember {
        NavigationRouterImpl(navController)
    },
    startDestination: String
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Destination.FaultsListScreen.route) {
            FaultsListScreen(navigation)
        }

        composable(route = Destination.AddFaultScreen.route) {
            AddFaultScreen(navigation)
        }
    }
}