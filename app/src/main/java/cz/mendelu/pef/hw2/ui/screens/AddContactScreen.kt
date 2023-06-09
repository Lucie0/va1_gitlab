package cz.mendelu.pef.hw2.ui.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import cz.mendelu.pef.hw2.model.Contact
import cz.mendelu.pef.hw2.navigation.INavigationRouter
import cz.mendelu.pef.hw2.ui.elements.BackArrowScreen
import cz.mendelu.pef.hw2.ui.elements.MyTextField
import cz.mendelu.pef.hw2.ui.elements.Spinner
import org.koin.androidx.compose.getViewModel
import cz.mendelu.pef.hw2.R

// spinner pro typ kontaktu
//https://www.geeksforgeeks.org/spinner-in-kotlin/


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
                //viewModel.initItem() -- kvuli edit screene jednoho kontaktu -- cekani na nacteni z db a/nebo/do VM
            }
            AddContactUIState.Saved -> {
                Toast.makeText(
                    LocalContext.current,
                    stringResource(R.string.contact_added),
                    Toast.LENGTH_SHORT
                ).show()

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
        AddContactScreenContent(
            navigation = navigation,
            viewModel = viewModel)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactScreenContent(
//    paddingValues: PaddingValues,
    navigation: INavigationRouter,
    viewModel: AddContactVM
) {

    // Jméno - povinné pole
    //● Příjmení - povinné pole
    //● Telefon - povinné pole
    //● Typ kontaktu (osobní/pracovní) - povinné pole - Spinner ^
    //● E-mailová adresa - nepovinné pole

    var text by remember { mutableStateOf("") }

    val options = listOf("Work", "Personal")
    var selectedOptionText by remember { mutableStateOf("") }

    Column(
//        modifier = Modifier.padding(paddingValues)
    ) {
        MyTextField(
            label = "First name",
            value = viewModel.data.fname,
            onValueChange = { viewModel.onFNameChanged(it) },
            error = viewModel.error_fname
        )
        MyTextField(
            label = "Last name",
            value = viewModel.data.lname,
            onValueChange = { viewModel.onLNameChanged(it) },
            error = viewModel.error_lname
        )
        MyTextField(
            label = "Phone number",
            value = viewModel.data.phone_number,
            onValueChange = { viewModel.onPhoneChanged(it) },
            error = viewModel.error_phone
        )

        Spinner(
            items = options,
            selectedItem = viewModel.data.type,
            onSelectedItemChanged = {
//                selectedOptionText = it
                viewModel.onTypeChanged(it)
            },
            error = viewModel.error_type
        )

        MyTextField(
            label = "E-mail",
            value = viewModel.data.email ?: "",
            onValueChange = { viewModel.onEmailChanged(it) }
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

        Icon(
            painter = painterResource(id = R.drawable.ic_android_black_24dp),
            contentDescription = null,
            modifier = Modifier.clickable { navigation.navigateBack() }
        )

        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null)


    }

}