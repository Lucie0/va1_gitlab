package com.example.contactsapp.ui.screens.contactList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.contactsapp.model.Contact
import com.example.contactsapp.navigation.INavigationRouter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsListScreen(navigation: INavigationRouter) {
    var contacts = remember { // aby si pamatoval i po znovuvykresleni screeny
        mutableStateListOf<Contact>()
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Contact List")
            }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
//                navigation.navigateToAddEditTaskScreen(-1L)
                navigation.navigateToAddContactScreen(-1L)
            }) {
                Text(text = "+")
            }
        }
    ) {
        ContactsListScreenContent(
            paddingValues = it,
            contacts = contacts,
            navigation = navigation
        )
        //(it, tasks, navigation, actions = viewModel) // VM dedi z actions, proto ho predavam
    }

}

@Composable
fun ContactsListScreenContent(
    paddingValues: PaddingValues,
    contacts: MutableList<Contact>,
    navigation: INavigationRouter
) {
    LazyColumn(modifier = Modifier.padding(paddingValues)) {
        contacts.forEach {
            item(key = it.id) { // aby se nerefreshovaly zaznamy, ktere jsou stale stejne, predani jedinecneho id
//                TaskRow(
//                    task = it,
//                    onRowClick = {
////                        navigation.navigateToAddEditTaskScreen(it.id)
//                                 // todo navigate to edit screen?
//                                 },
////                    actions = actions
//                )



            }
        }

    }
}

@Composable
fun ContactRow(
    contact: Contact,
    onRowClick: () -> Unit
) {
    Column {
        ListItem(
            leadingContent = {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(color = Color.Cyan)
                ) // todo random color
            }
        ) {
            Text(text = contact.fname[0].toString().uppercase())

        }

    }
}


@Composable
fun TwoLineListItem() {
    Column {
        ListItem(
            headlineContent = { Text("Two line list item with trailing") },
            supportingContent = { Text("Secondary text") },
            trailingContent = { Text("meta") },
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                )
            }
        )
        Divider()
    }
}