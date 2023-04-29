package cz.mendelu.pef.cv1.navigation

import androidx.navigation.NavController

interface INavigationRouter {
    fun navigateBack()
    fun navigateToAddEditTaskScreen(id: Long?)
    fun navigateToMap(latitude: Double?, longitude: Double?)
    fun getNavController(): NavController
    fun returnFromMap(latitude: Double, longitude: Double) // vraceni se z mapy -> mam vzdy nejake souradnice, cili se povedlo, nebo nic nemam a provedu navigateBack§§§
}