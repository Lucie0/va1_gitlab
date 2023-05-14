package cz.mendelu.pef.mapappdistance.navigation

import androidx.navigation.NavController

interface INavigationRouter {
    fun navigateBack()

    fun navigateToShowDistanceScreen(latitude1: Double, longitude1: Double, latitude2: Double, longitude2: Double,)

    fun getNavController(): NavController
}