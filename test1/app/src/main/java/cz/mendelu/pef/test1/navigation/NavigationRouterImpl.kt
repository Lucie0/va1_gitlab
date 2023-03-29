package cz.mendelu.pef.test1.navigation

import androidx.navigation.NavController
import androidx.navigation.NavHostController

class NavigationRouterImpl (private val navController: NavHostController) : INavigationRouter {
    override fun navigateBack() {
        navController.popBackStack()
    }

    override fun navigateToListOfWordsScreen() {
        navController.navigate(Destination.ListOfWordsScreen.route)
    }

    override fun navigateToAddItemScreen() {
        navController.navigate(Destination.AddItemScreen.route)
    }

    override fun getNavController(): NavController = navController

}