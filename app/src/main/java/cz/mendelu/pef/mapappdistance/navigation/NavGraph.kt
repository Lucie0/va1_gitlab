package cz.mendelu.pef.mapappdistance.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import cz.mendelu.pef.mapappdistance.model.Location
import cz.mendelu.pef.mapappdistance.ui.screens.choosePoint.ChoosePointMapScreen
import cz.mendelu.pef.mapappdistance.ui.screens.showDistance.ShowDistanceMapScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),//aby si pamatoval, kde je
    navigation: INavigationRouter = remember {
        NavigationRouterImpl(navController)
    },
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Destination.ChoosePointMapScreen.route) {
            ChoosePointMapScreen(navigation) // zavolani jine composable fce a jen se zavola
        }

        composable(route = Destination.ShowDistanceMapScreen.route + "/{location}",
            arguments = listOf(
                navArgument("location"){
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {

            val locationString = it.arguments?.getString("location")
            if (!locationString.isNullOrEmpty()){
                val moshi: Moshi = Moshi.Builder().build()
                val jsonAdapter: JsonAdapter<Location> = moshi.adapter(Location::class.java)

                val location = jsonAdapter.fromJson(locationString)

                if (location != null) {
                    ShowDistanceMapScreen(
                        navigation = navigation,
                        latitude1 = location.latitude1,
                        longitude1 = location.longitude1,
                        latitude2 = location.latitude2,
                        longitude2 = location.longitude2
                    )
                }
            }
        }
    }
}