package cz.mendelu.pef.test1.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cz.mendelu.pef.test1.ui.screens.addItem.AddItemScreen
import cz.mendelu.pef.test1.ui.screens.listOfWords.ListOfWordsScreen
import cz.mendelu.pef.test1.ui.screens.mainScreen.MainScreen

@Composable
fun NavGraph(navController: NavHostController = rememberNavController(), //aby si pamatoval, kde je
             navigation: INavigationRouter = remember {
                 NavigationRouterImpl(navController)
             },
             startDestination: String
){
    NavHost(navController = navController,
        startDestination = startDestination) {

        composable(route = Destination.MainScreen.route) {
            MainScreen(navigation)
        }

        composable(route = Destination.AddItemScreen.route) {
            AddItemScreen(navigation)
        }

        composable(route = Destination.ListOfWordsScreen.route) {
            ListOfWordsScreen(navigation)
        }
    }
}