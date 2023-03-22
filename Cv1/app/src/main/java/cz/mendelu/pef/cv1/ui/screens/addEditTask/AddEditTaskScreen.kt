package cz.mendelu.pef.cv1.ui.screens.addEditTask

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import cz.mendelu.pef.cv1.navigation.INavigationRouter
import cz.mendelu.pef.cv1.ui.elements.BackArrowScreen
import org.koin.androidx.compose.getViewModel
import androidx.compose.material3.OutlinedTextField as OutlinedTextField1

@Composable
fun AddEditTaskScreen(
    navigation: INavigationRouter,
    id: Long?,
    viewModel: AddEditTaskViewModel = getViewModel()
){
    viewModel.addEditTaskUIState.value.let {
        when(it){
            AddEditTaskUIState.Default -> {

            }
            AddEditTaskUIState.TaskSaved -> {
                // zajistit, ze se provadi necomposable kod uvnitr composable -> provede se jen jednou, ne dvakrat
                LaunchedEffect(it) {
                    navigation.navigateBack()
                }
            }
        }
    }
    BackArrowScreen(
        appBarTitle = "Add Edit Task Screen",
        onBackClick = {
            navigation.navigateBack()
        }) {
        AddEditTaskScreenContent(actions = viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditTaskScreenContent(actions: AddEditTaskActions){ // content nemusi znat VM, staci, kdyz obrazovka pomoci DI (v param)
    var text = remember {
        mutableStateOf("")
    }

    OutlinedTextField1(value = text.value, onValueChange = {// potreba nastavit i jako promennou, aby se zobrazovala
        text.value = it // jakmile se zmeni hodnota, tak se to zapise do promenne
    })

    OutlinedButton(onClick = {
        actions.saveTask()
    }) {
        Text(text = "Save task")

    }
}