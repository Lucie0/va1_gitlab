package cz.mendelu.pef.cv1.ui.screens.addEditTask

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import cz.mendelu.pef.cv1.navigation.INavigationRouter
import cz.mendelu.pef.cv1.ui.elements.BackArrowScreen
import org.koin.androidx.compose.getViewModel
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.res.stringResource
import cz.mendelu.pef.cv1.ui.elements.MyTextField

@Composable
fun AddEditTaskScreen(
    navigation: INavigationRouter,
    id: Long?,
    viewModel: AddEditTaskViewModel = getViewModel()
){

    viewModel.taskId = id // inicalizace id z VM
    // na zacatku bude obrazovka nacitat data

    var data: AddEditScreenData by remember {
        mutableStateOf(viewModel.data)
    }

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
            AddEditTaskUIState.TaskChanged -> {
                // pokud dojde ke zmene tasku, tak potrebuju zaridit, aby se provedla rekompozice
                data = viewModel.data
                viewModel.addEditTaskUIState.value = AddEditTaskUIState.Default

            }
            AddEditTaskUIState.Loading -> {
                // nacitani
                viewModel.initTask()
            }
        }
    }
    BackArrowScreen(
        appBarTitle = "Add Edit Task Screen",
        onBackClick = {
            navigation.navigateBack()
        }) {
        AddEditTaskScreenContent(
            actions = viewModel,
            data = data
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditTaskScreenContent(
    actions: AddEditTaskActions,
    data: AddEditScreenData
) { // content nemusi znat VM, staci, kdyz obrazovka pomoci DI (v param)

    // var text = remember {
    // mutableStateOf("")
    // }
    // -> udrzuju si data ve VM, takze sem jen probublaji dolu vvv


    // policka vytahovat do samostanyuch composable fci a vytvorit si nove elementy

    if (!data.loading) {
//        OutlinedTextField(
//            value = data.task.text,
//            onValueChange = {
//                // potreba nastavit i jako promennou, aby se zobrazovala
//                // data.task.text = it // jakmile se zmeni hodnota, tak se to zapise do promenne
//
//                // text se zmenil
//                actions.onTextChange(it)
//            })
        MyTextField(
            value = data.task.text,
            hint = "Task text",
            onValueChange = { actions.onTextChange(it) },
            error = if (data.taskTextError != null)
                stringResource(id = data.taskTextError!!) else "" // adresa stringu
         )

        OutlinedButton(onClick = {
            actions.saveTask()
        }) {
            Text(text = "Save task")
        }
    } else {
        // todo loading screen
    }
}