package cz.mendelu.pef.hw2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cz.mendelu.pef.hw2.ui.screens.AddContactScreen
import cz.mendelu.pef.hw2.ui.screens.ContactsListScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),//aby si pamatoval, kde je
    navigation: NavigationRouterImpl = remember {
        NavigationRouterImpl(navController)
    },
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Destination.ContactsListScreen.route) {
            ContactsListScreen(navigation) // zavolani jine composable fce a jen se zavola
        }

        composable(
            route = Destination.AddContactScreen.route // + "/{id}", // receni, ze to bude paramter v ceste
        ) {
            AddContactScreen(navigation)

        }
    }
}

//            arguments = listOf(
//                navArgument("id"){
//                    type = NavType.LongType
//                    defaultValue = -1L
//                }
//            )
//        ){
//            val id = it.arguments?.getLong("id") // arg muze vracet null
//            AddEditTaskScreen(
//                navigation = navigation,
//                id = if (id != -1L) id else null
//            )


