package cz.mendelu.pef.app_test_1.navigation

import androidx.navigation.NavController

interface INavigationRouter {
    fun navigateBack()
    fun navigateToAddCarScreen()

    fun getNavController(): NavController

    //    fun returnFromMap(latitude: Double, longitude: Double) // vraceni se z mapy -> mam vzdy nejake souradnice, cili se povedlo, nebo nic nemam a provedu navigateBack§§§
//    fun navigateToMap(latitude: Double?, longitude: Double?)
}
