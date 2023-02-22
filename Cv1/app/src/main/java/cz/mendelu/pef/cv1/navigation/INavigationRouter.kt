package cz.mendelu.pef.cv1.navigation

import androidx.navigation.NavController

interface INavigationRouter {
    fun navigateBack()
    fun navigateToAddEditTaskScreen()
    fun navigateToMap()
    fun getNavController(): NavController
}