package cz.mendelu.pef.cv1.ui.screens.addEditTask

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import cz.mendelu.pef.cv1.R
import cz.mendelu.pef.cv1.navigation.INavigationRouter
import cz.mendelu.pef.cv1.ui.elements.BackArrowScreen
import org.koin.androidx.compose.getViewModel
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import cz.mendelu.pef.cv1.extensions.round
import cz.mendelu.pef.cv1.model.Location
import cz.mendelu.pef.cv1.ui.elements.InfoElement
import cz.mendelu.pef.cv1.ui.elements.MyTextField
import cz.mendelu.pef.cv1.utils.DateUtils
import java.util.*

@Composable
fun AddEditTaskScreen(
    navigation: INavigationRouter,
    id: Long?,
    viewModel: AddEditTaskViewModel = getViewModel()
){

    viewModel.taskId = id // inicalizace id z VM
    // na zacatku bude obrazovka nacitat data

    //ziskani objektu LiveData -- objekt, ktery posloucha nad zmenami
    val mapDataResult = navigation
        .getNavController()
        .currentBackStackEntry
        ?.savedStateHandle
        ?.getLiveData<String>("location")
        ?.observeAsState()


    mapDataResult?.value?.let {
        // ziskani hodnoty v resultu -- string -- kyzeny json
        val moshi: Moshi = Moshi.Builder().build()
        val jsonAdapter: JsonAdapter<Location> = moshi.adapter(Location::class.java)

        val location = jsonAdapter.fromJson(it)

        if(location != null) {
            viewModel.onLocationChanged(location.latitude, location.longitude)
        }

        navigation.getNavController()
            .currentBackStackEntry
            ?.savedStateHandle
            ?.remove<String>("location")
    }

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
            navigation = navigation,
            data = data
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditTaskScreenContent(
    actions: AddEditTaskActions,
    navigation: INavigationRouter,
    data: AddEditScreenData
) { // content nemusi znat VM, staci, kdyz obrazovka pomoci DI (v param)

    // var text = remember {
    // mutableStateOf("")
    // }
    // -> udrzuju si data ve VM, takze sem jen probublaji dolu vvv


    // policka vytahovat do samostanych composable fci a vytvorit si nove elementy

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

        val calendar = Calendar.getInstance()
        data.task.date?.let {
            calendar.timeInMillis = it
        }

        val y = calendar.get(Calendar.YEAR)
        val m = calendar.get(Calendar.MONTH)
        val d = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            LocalContext.current,
            { dialog: DatePicker, year: Int, month: Int, day: Int ->
                actions.onDateChange(DateUtils.getUnixTime(year, month, day))
            },
            y,
            m,
            d
        )

        InfoElement(
            value = if(data.task.date != null)
                DateUtils.getDateString(data.task.date!!) else null,
            label = stringResource(R.string.date),
            leadingIcon = R.drawable.ic_event_24,
            onClick = {
                datePickerDialog.show()
            },
            onClearClick = {
                actions.onDateChange(null)
            }
        )

        InfoElement(
            //todo odkomentovat
//            value = if (data.task.hasLocation())
//                "${data.task.latitude!!.round()}, ${data.task.longitude!!}"
//                else "",
            value = "TODO value",

            label = "Location",
            leadingIcon = R.drawable.ic_event_24,
            onClick = {
                navigation.navigateToMap(data.task.latitude, data.task.longitude)
            },
            onClearClick = {
                // smazani hodnoty
                actions.onLocationChanged(null, null)
            }
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