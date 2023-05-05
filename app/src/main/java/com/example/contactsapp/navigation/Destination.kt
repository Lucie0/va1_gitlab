package com.example.contactsapp.navigation

sealed class Destination (val route: String) { // trida, ktera v sobe obsahuje dalsi tridy, je to vyctovy typ trid, obdoba predka a potomku
    // kdyz je to val, tak je to atribut tridy
    object ContactsListScreen : Destination(route = "contact_list")
    object AddContactScreen : Destination(route = "add_contact")
}
