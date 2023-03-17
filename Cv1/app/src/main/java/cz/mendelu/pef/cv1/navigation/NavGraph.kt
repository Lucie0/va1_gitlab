package cz.mendelu.pef.cv1.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cz.mendelu.pef.cv1.ui.screens.addEditTask.AddEditTaskScreen
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
    }
}