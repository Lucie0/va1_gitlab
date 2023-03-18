package cz.mendelu.pef.homework1.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cz.mendelu.pef.homework1.ui.elements.Operators
import cz.mendelu.pef.homework1.ui.screens.MainScreen
import cz.mendelu.pef.homework1.ui.screens.OperationScreen
import cz.mendelu.pef.homework1.ui.screens.ResultScreen


@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),//aby si pamatoval, kde je
    navigation: INavigationRouter = remember {
        NavigationRouterImpl(navController)
    },
    startDestination: String
){
    NavHost(navController = navController,
        startDestination = startDestination){
        composable(
            route = Destination.MainScreen.route){
            MainScreen(navigation) // zavolani jine composable fce a jen se zavola
        }

        composable( // TODO vratit zakomentovanou verzi (2 casti)
            // TODO cast 1
            route = Destination.OperationScreen.route + "/{num}", // receni, ze to bude paramter v ceste
            arguments = listOf(
                navArgument("num"){
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        )
            // ---------- meziverze na testovani
//        route = Destination.OperationScreen.route){
//            OperationScreen(navigation = navigation, num = 1) // todo zmenit, cislo je napevno
//        }
            // ----------
        // TODO cast2
        {
            val num = it.arguments?.getInt("num") // arg muze vracet null
            OperationScreen(
                navigation = navigation,
                num = if (num != -1) num else null
            )
        }

        composable(
            route = Destination.ResultScreen.route + "/{operator}/{num}",
            arguments = listOf(
                navArgument("num"){
                    type = NavType.IntType
                    defaultValue = -1
                },
                navArgument("operator"){
//                    TODO type = NavType., potrebuju enum?
                    type = NavType.StringType
//                    defaultValue = Operators.ADDITION // todo
                    defaultValue = "ADD"
                }
            )){
            val num = it.arguments?.getInt("num")
            val operator = it.arguments?.getString("operator") // todo potrebuju enum
            ResultScreen(
                navigation = navigation,
                operator = operator,
                num = num) // todo zmenit, operaace napevno
        }
    }
}