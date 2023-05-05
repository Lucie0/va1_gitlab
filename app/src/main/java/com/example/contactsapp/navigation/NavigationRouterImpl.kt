package com.example.contactsapp.navigation

import androidx.navigation.NavController

class NavigationRouterImpl(private val navController: NavController) : INavigationRouter {
    override fun navigateBack() {
    // do stacku se pridavaji obrazovky, neaktivni jsou uspane,
    // posledni (aktivni) polozka se vyhodi
        navController.popBackStack()
    }

    override fun navigateToAddContactScreen(id: Long?) {
        navController.navigate(Destination.AddContactScreen.route)
    }

    // getter
    override fun getNavController(): NavController = navController
}