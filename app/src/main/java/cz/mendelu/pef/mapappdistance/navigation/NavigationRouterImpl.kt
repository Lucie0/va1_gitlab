package cz.mendelu.pef.mapappdistance.navigation

import androidx.navigation.NavController
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import cz.mendelu.pef.mapappdistance.model.Location

class NavigationRouterImpl(private val navController: NavController) : INavigationRouter {
    override fun navigateBack() {
        navController.popBackStack()
    }

    override fun navigateToShowDistanceScreen(
        latitude1: Double,
        longitude1: Double,
        latitude2: Double,
        longitude2: Double
    ){
        val moshi: Moshi = Moshi.Builder().build()
        // jaka trida se bude prevadet
        val jsonAdapter: JsonAdapter<Location> = moshi.adapter(Location::class.java)

        val jsonString = jsonAdapter.toJson(
            Location(
                latitude1 = latitude1,
                longitude1 = longitude1,
                latitude2 = latitude2,
                longitude2 = longitude2
            ))
        navController.navigate(Destination.ShowDistanceMapScreen.route + "/" + jsonString)

    }

    override fun getNavController(): NavController = navController

}