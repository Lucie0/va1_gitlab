package cz.mendelu.pef.app_test_1.navigation

import androidx.navigation.NavController

class NavigationRouterImpl(private val navController: NavController) : INavigationRouter {

    override fun getNavController(): NavController = navController

    override fun navigateBack() {
        navController.popBackStack()
    }

    override fun navigateToAddCarScreen() {
        navController.navigate(Destination.AddCarScreen.route)
    }
}
