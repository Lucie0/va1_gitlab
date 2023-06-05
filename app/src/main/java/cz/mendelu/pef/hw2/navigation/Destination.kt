package cz.mendelu.pef.hw2.navigation

sealed class Destination(val route: String) {
    object ContactsListScreen: Destination(route = "contact_list")
    object AddContactScreen: Destination(route = "add_contact")
}