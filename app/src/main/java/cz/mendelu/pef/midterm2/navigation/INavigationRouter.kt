package cz.mendelu.pef.midterm2.navigation

import androidx.navigation.NavController

interface INavigationRouter {
    fun navigateBack()
    fun navigateToAddPlayerScreen(id: Long?)
    fun navigateToPlayerOnMatchScreen(id: Long?)

    fun getNavController(): NavController
}