package cz.mendelu.pef.test1.navigation

import androidx.navigation.NavController

interface INavigationRouter {
    fun navigateBack()
    fun navigateToListOfWordsScreen()
    fun navigateToAddItemScreen()
    fun getNavController(): NavController
}