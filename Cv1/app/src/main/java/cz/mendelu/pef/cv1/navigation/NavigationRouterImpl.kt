package cz.mendelu.pef.cv1.navigation

import androidx.navigation.NavController
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import cz.mendelu.pef.cv1.model.Location

class NavigationRouterImpl(private val navController: NavController) : INavigationRouter {
    override fun navigateBack() {
    // do stacku se pridavaji obrazovky, neaktivni jsou uspane,
    // posledni (aktivni) polozka se vyhodi
        navController.popBackStack()
    }

    override fun navigateToAddEditTaskScreen(id: Long?) {
    // skladani url, lze pridavat paramtery za sebe oddelene lomitkem
        navController.navigate(Destination.AddEditTaskScreen.route + "/" + id)

    }

    // getter
    override fun getNavController(): NavController = navController


    override fun navigateToMap(latitude: Double?, longitude: Double?) {
        if (latitude != null && longitude != null) {
            // serializace na json
            val moshi: Moshi = Moshi.Builder().build()
            // jaka trida se bude prevadet
            val jsonAdapter: JsonAdapter<Location> = moshi.adapter(Location::class.java)

            val jsonString = jsonAdapter.toJson(
                Location(
                    latitude = latitude,
                    longitude = longitude))

            navController.navigate(Destination.MapScreen.route + "/" + jsonString)

        } else {
            // neposilam lat a lon
            navController.navigate(Destination.MapScreen.route)
        }
    }

    override fun returnFromMap(latitude: Double, longitude: Double) {
        val moshi: Moshi = Moshi.Builder().build()
        val jsonAdapter: JsonAdapter<Location> = moshi.adapter(Location::class.java)
        val jsonString = jsonAdapter.toJson(
            Location(
                latitude = latitude,
                longitude = longitude))

        navController.previousBackStackEntry?.savedStateHandle?.set(
            "location", jsonString
        ) // dostani se k predchozi obrazovce v zasobniku, muze byt null
        // savedStateHandle -- prezije vsechno, i kdyz dojde pamet;
        // kdyz nic do ni neulozim, je null

        navigateBack()
    }

}