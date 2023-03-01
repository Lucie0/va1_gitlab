package cz.mendelu.pef.cv1.navigation

import androidx.navigation.NavController

class NavigationRouterImpl(private val navController: NavController) : INavigationRouter {
    override fun navigateBack() {
    // do stacku se pridavaji obrazovky, neaktivni jsou uspane,
    // posledni (aktivni) polozka se vyhodi
        navController.popBackStack()
    }

    override fun navigateToAddEditTaskScreen(id: Long?) {
    // skladani url, lze pridavat paramtery za sebe oddelene lomitkem
        navController.navigate(Destination.AddEditTaskScreen.route + "/" + id)

    }

    override fun navigateToMap() {
        TODO("Not yet implemented")
    }

    // getter
    override fun getNavController(): NavController = navController
}