package cz.mendelu.pef.app_test_1.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cz.mendelu.pef.app_test_1.ui.screens.AddCarScreen

import cz.mendelu.pef.app_test_1.ui.screens.CarListScreen

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
        composable(route = Destination.CarListScreen.route) {
            CarListScreen(navigation) // zavolani jine composable fce a jen se zavola
        }

        composable(
            route = Destination.AddCarScreen.route // + "/{id}", // receni, ze to bude paramter v ceste
        ){
            AddCarScreen(navigation)

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

