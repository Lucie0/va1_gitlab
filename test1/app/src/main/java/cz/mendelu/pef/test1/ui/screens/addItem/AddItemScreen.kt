package cz.mendelu.pef.test1.ui.screens.addItem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cz.mendelu.pef.test1.navigation.INavigationRouter
import cz.mendelu.pef.test1.ui.elements.BackArrowScreen
import org.koin.androidx.compose.getViewModel

@Composable
fun AddItemScreen(navigation: INavigationRouter,
viewModel: AddItemViewModel = getViewModel()) {
    BackArrowScreen(
        appBarTitle = "Add Item",
        onBackClick = {
            navigation.navigateBack()
        }) {
        AddItemScreenContent(it, actions = viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItemScreenContent(paddingValues: PaddingValues, actions: AddItemActions) {
    var cz_word: String
    var en_word: String
    Column(modifier = Modifier.padding(paddingValues)) {
        OutlinedTextField(
            value = "", // prom text, mutable state
            label = { Text(text = "Word") },
            onValueChange = {
//                text = it
            }
        )

        OutlinedTextField(
            value = "", // prom text, mutable state
            label = { Text(text = "English translation") },
            onValueChange = {
//                text = it
            }
        )

        Button(onClick = {
            //save word
            actions.saveWord("cz_word", "en_word")
        }) {
            Text(text = "Save")
        }
    }
}