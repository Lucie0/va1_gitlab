package cz.pef.mendelu.exam.navigation

import androidx.navigation.NavController

interface INavigationRouter {
    fun navigateBack()

    fun navigateToAddFaultScreen()

    fun getNavController(): NavController
}