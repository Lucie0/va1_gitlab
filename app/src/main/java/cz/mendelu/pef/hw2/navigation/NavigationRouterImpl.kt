package cz.mendelu.pef.hw2.navigation

import androidx.navigation.NavController

class NavigationRouterImpl(private val navController: NavController) : INavigationRouter {

    override fun getNavController(): NavController = navController

    override fun navigateBack() {
        navController.popBackStack()
    }

    override fun navigateToAddContactScreen() {
        navController.navigate(Destination.AddContactScreen.route)
    }
}
