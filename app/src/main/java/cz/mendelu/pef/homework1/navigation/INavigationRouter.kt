package cz.mendelu.pef.homework1.navigation

import androidx.navigation.NavController
import cz.mendelu.pef.homework1.ui.elements.Operators

interface INavigationRouter {
    fun navigateBack()
    fun navigateToOperationScreen(num: Int?) // todo muze byt null ci ne?
//    fun navigateToResultScreen(operator: Operators, num: Int?)
    fun navigateToResultScreen(operator: String, num: Int?)
    fun getNavController(): NavController
}