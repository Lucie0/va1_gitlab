package com.example.contactsapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.contactsapp.ui.screens.addContact.AddContactScreen
import com.example.contactsapp.ui.screens.contactList.ContactsListScreen

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
        composable(route = Destination.ContactsListScreen.route){
            ContactsListScreen(navigation) // zavolani jine composable fce a jen se zavola
        }

        composable(
            route = Destination.AddContactScreen.route// + "/{id}", // receni, ze to bude paramter v ceste
//            arguments = listOf(
//                navArgument("id"){
//                    type = NavType.LongType
//                    defaultValue = -1L
//                }
//            )
        ){
//            val id = it.arguments?.getLong("id") // arg muze vracet null
            AddContactScreen(
                navigation = navigation
//                id = if (id != -1L) id else null
            )
        }

    }
}