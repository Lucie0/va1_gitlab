package cz.mendelu.pef.cv1.navigation

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
import cz.mendelu.pef.cv1.model.Location
import cz.mendelu.pef.cv1.ui.screens.addEditTask.AddEditTaskScreen
import cz.mendelu.pef.cv1.ui.screens.map.MapScreen
import cz.mendelu.pef.cv1.ui.screens.taskList.TaskListScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),//aby si pamatoval, kde je
    navigation: INavigationRouter = remember {
        NavigationRouterImpl(navController)
    },
    startDestination: String
){
    NavHost(navController = navController,
        startDestination = startDestination){
        composable(route = Destination.TaskListScreen.route){
            TaskListScreen(navigation) // zavolani jine composable fce a jen se zavola
        }

        composable(
            route = Destination.AddEditTaskScreen.route + "/{id}", // receni, ze to bude paramter v ceste
            arguments = listOf(
                navArgument("id"){
                    type = NavType.LongType
                    defaultValue = -1L
                }
            )
        ){
            val id = it.arguments?.getLong("id") // arg muze vracet null
            AddEditTaskScreen(
                navigation = navigation,
                id = if (id != -1L) id else null
            )
        }
        // situace, ktera osetruje stav, kdy nemam zadne lat a lon a jen si ji chci zobrazit
        composable(Destination.MapScreen.route){
            MapScreen(navigation = navigation, latitude = null, longitude = null)
        }

        // situace, kdy uz nejake souradnice mam -- jina cesta (oddeleni metod)
        composable(Destination.MapScreen.route + "/{location}",
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

                MapScreen(
                    navigation = navigation,
                    latitude = location!!.latitude,
                    longitude = location.longitude
                )
            } else {
                MapScreen(navigation = navigation, latitude = null, longitude = null)
            }
        }

    }
}