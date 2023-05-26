package cz.mendelu.pef.midterm2.navigation

import androidx.navigation.NavController

class NavigationRouterImpl(private val navController: NavController) : INavigationRouter {

    override fun getNavController(): NavController = navController

    override fun navigateBack() {
        navController.popBackStack()
    }

    override fun navigateToAddPlayerScreen(id: Long?) {
        navController.navigate(Destination.AddPlayerScreen.route + "/" + id)
    }

    override fun navigateToPlayerOnMatchScreen(id: Long?) {
        navController.navigate(Destination.PlayerOnMatchScreen.route + "/" + id)
    }

}