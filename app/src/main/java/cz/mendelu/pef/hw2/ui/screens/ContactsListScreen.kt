package cz.mendelu.pef.hw2.ui.screens

import cz.mendelu.pef.hw2.model.Contact
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cz.mendelu.pef.hw2.navigation.INavigationRouter
import org.koin.androidx.compose.getViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsListScreen(
    navigation: INavigationRouter,
    viewModel: ContactsListVM = getViewModel()
) {
    var contacts = remember { // aby si pamatoval i po znovuvykresleni screeny
        mutableStateListOf<Contact>()
    }

    contacts.add(
        Contact(
            fname = "aa",
            lname = "b",
            phone_number = "789789789",
            type = "work"
        )
    )
    contacts.add(
        Contact(
            fname = "CC",
            lname = "b",
            phone_number = "11111111",
            type = "work"
        )
    )


    viewModel.contactsListUIState.value.let {  // nad promennou ve VM neco provedu
        when(it) {
            ContactsListUIState.Default -> {
                viewModel.load()
            }
            is ContactsListUIState.Success -> {
                contacts.clear()
                contacts.addAll(it.items)
            }
        }
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
                navigation.navigateToAddContactScreen()
            }) {
                Text(text = "+")
            }
        }
    ) {
        ContactsListScreenContent(
            paddingValues = it,
            contacts = contacts,
//            navigation = navigation
        )
        //(it, tasks, navigation, actions = viewModel) // VM dedi z actions, proto ho predavam
    }

}

@Composable
fun ContactsListScreenContent(
    paddingValues: PaddingValues,
    contacts: MutableList<Contact>,
//    navigation: INavigationRouter
) {
    LazyColumn(modifier = Modifier.padding(paddingValues)) {
        contacts.forEach {
            item(key = it.id) { // aby se nerefreshovaly zaznamy, ktere jsou stale stejne, predani jedinecneho id
                ContactRow(
                    contact = it,
                )
                Divider()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactRow(
    contact: Contact,
//    onRowClick: () -> Unit
) {
    Column {
        ListItem(
            headlineText = {
                Text(contact.fname)
            },
            supportingText = {
                Text(contact.phone_number)
            },
            leadingContent = {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(32.dp) //40.dp)
                        .clip(CircleShape)
                        .background(color = Color.Cyan)

                    // todo random color
                )
                {
                    Text(text = contact.fname[0].toString().uppercase())
                }
            })

    }
}


//@Composable
//fun TwoLineListItem() {
//    Column {
//        ListItem(
//            headlineContent = { Text("Two line list item with trailing") },
//            supportingContent = { Text("Secondary text") },
//            trailingContent = { Text("meta") },
//            leadingContent = {
//                Icon(
//                    Icons.Filled.Favorite,
//                    contentDescription = "Localized description",
//                )
//            }
//        )
//        Divider()
//    }
//}