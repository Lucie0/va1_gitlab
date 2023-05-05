package com.example.contactsapp.navigation

import androidx.navigation.NavController

interface INavigationRouter {
    fun navigateBack()
    fun navigateToAddContactScreen(id: Long?)
    fun getNavController(): NavController
}