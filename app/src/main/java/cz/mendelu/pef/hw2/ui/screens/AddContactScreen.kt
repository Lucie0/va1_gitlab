package cz.mendelu.pef.hw2.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import cz.mendelu.pef.hw2.model.Contact
import cz.mendelu.pef.hw2.navigation.INavigationRouter
import cz.mendelu.pef.hw2.ui.elements.BackArrowScreen
import cz.mendelu.pef.hw2.ui.elements.MyTextField
import cz.mendelu.pef.hw2.ui.elements.Spinner
import org.koin.androidx.compose.getViewModel

// spinner pro typ kontaktu
//https://www.geeksforgeeks.org/spinner-in-kotlin/


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactScreen(
    navigation: INavigationRouter,
    viewModel: AddContactVM = getViewModel()
) {
    var data: Contact by remember {
        mutableStateOf(viewModel.data)
    }

    viewModel.addContactUIState.value.let {
        when (it) {
            AddContactUIState.Default -> {}

            AddContactUIState.Changed -> {
                data = viewModel.data
                viewModel.addContactUIState.value = AddContactUIState.Default
            }

            AddContactUIState.Loading -> {
                //viewModel.initItems()
            }
            AddContactUIState.Saved -> {
                LaunchedEffect(it) {
                    navigation.navigateBack()
                }
            }
        }
    }

    BackArrowScreen(
        appBarTitle = "Add Contact",
        onBackClick = { navigation.navigateBack() }
    ) {
        AddContactScreenContent(navigation = navigation, viewModel)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactScreenContent(
//    paddingValues: PaddingValues,
    navigation: INavigationRouter,
    viewModel: AddContactVM
) {

    // todo var data = viewModel.data

    // Jméno - povinné pole
    //● Příjmení - povinné pole
    //● Telefon - povinné pole
    //● Typ kontaktu (osobní/pracovní) - povinné pole - Spinner ^
    //● E-mailová adresa - nepovinné pole

    var text by remember { mutableStateOf("") }

    // todo vm -- data

    val options = listOf("Work", "Personal")
    var selectedOptionText by remember { mutableStateOf("") }

    Column(
//        modifier = Modifier.padding(paddingValues)
    ) {
        MyTextField(
            label = "First name",
            value = viewModel.data.fname,
            onValueChange = { viewModel.onFNameChanged(it) }
        )
        MyTextField(
            label = "Last name",
            value = viewModel.data.lname,
            onValueChange = { viewModel.onLNameChanged(it) },
        )
        MyTextField(
            label = "Phone number",
            value = viewModel.data.phone_number,
            onValueChange = { viewModel.onPhoneChanged(it) }
        )

        Spinner(
            items = options,
            selectedItem = viewModel.data.type,
            onSelectedItemChanged = {
//                selectedOptionText = it
                viewModel.onTypeChanged(it)
            }
        )

        MyTextField(
                label = "E-mail",
                value = viewModel.data.email.toString(),
                onValueChange = { viewModel.onEmailChanged(it) },
            )

//        if (viewModel.data.email != null) {
//            MyTextField(
//                label = "E-mail",
//                value = viewModel.data.email!!,
//                onValueChange = { viewModel.onEmailChanged(it) },
//            )
//        } else {
//            MyTextField(
//                label = "E-mail",
//                value = "",
//                onValueChange = { viewModel.onEmailChanged(it) },
//            )
//        }

        OutlinedButton(onClick = {
            viewModel.save()
            print("SAVING")
        }) {
            Text(text = "Save")
        }

//        Icon(
//            painter = painterResource(id = R.drawable.ic_android_black_24dp),
//            contentDescription = null
//        )
//
//        Icon(imageVector = Icons.Default.Add, contentDescription = null)


    }

}