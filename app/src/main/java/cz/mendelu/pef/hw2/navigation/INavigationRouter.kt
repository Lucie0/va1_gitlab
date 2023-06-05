package cz.mendelu.pef.hw2.navigation

import androidx.navigation.NavController

interface INavigationRouter {
    fun navigateBack()
    fun navigateToAddContactScreen()

    fun getNavController(): NavController

    //    fun returnFromMap(latitude: Double, longitude: Double) // vraceni se z mapy -> mam vzdy nejake souradnice, cili se povedlo, nebo nic nemam a provedu navigateBack§§§
//    fun navigateToMap(latitude: Double?, longitude: Double?)
}
