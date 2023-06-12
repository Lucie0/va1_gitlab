package cz.pef.mendelu.exam.navigation

import androidx.navigation.NavController

class NavigationRouterImpl(private val navController: NavController) : INavigationRouter {
    override fun navigateBack() {
        navController.popBackStack()
    }

    override fun navigateToAddFaultScreen() {
        navController.navigate(Destination.AddFaultScreen.route)
    }

    override fun getNavController(): NavController = navController

}