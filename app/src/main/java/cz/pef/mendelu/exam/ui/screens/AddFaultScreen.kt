package cz.pef.mendelu.exam.ui.screens

import android.app.DatePickerDialog
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import cz.pef.mendelu.exam.R
import cz.pef.mendelu.exam.model.Fault
import cz.pef.mendelu.exam.navigation.INavigationRouter
import cz.pef.mendelu.exam.ui.elements.BackArrowScreen
import cz.pef.mendelu.exam.ui.elements.InfoElement
import cz.pef.mendelu.exam.ui.elements.MyTextField
import cz.pef.mendelu.exam.ui.utils.DateUtils
import org.koin.androidx.compose.getViewModel
import java.util.*

@Composable
fun AddFaultScreen(
    navigation: INavigationRouter,
    viewModel: AddFaultVM = getViewModel()
) {

    var data: Fault by remember { mutableStateOf(viewModel.data) }

    viewModel.uiState.value.let {
        when (it) {
            AddFaultUIState.Default -> {}
            AddFaultUIState.Changed -> {
                data = viewModel.data
                viewModel.uiState.value = AddFaultUIState.Default
            }
            AddFaultUIState.Saved -> {
                Toast.makeText(
                    LocalContext.current,
                    stringResource(R.string.saved),
                    Toast.LENGTH_SHORT
                ).show()

                LaunchedEffect(it) {
                    navigation.navigateBack()
                }
            }
        }
    }

    BackArrowScreen(
        appBarTitle = "Pridat zaznam",
        onBackClick = { navigation.navigateBack() }
    ) {
        AddFaultScreenContent(
            data = data,
            viewModel = viewModel
        )
    }

}

@Composable
fun AddFaultScreenContent(
    data: Fault,
    viewModel: AddFaultVM
) {
    MyTextField(
        value = data.text,
        label = "Duvod",
        onValueChange = { viewModel.onTextChange(it) },
        error = viewModel.errorText,
    )

    MyTextField(
        value = data.points.toString(),
        label = "Body",
        onValueChange = { viewModel.onPointsChange(it) },
        error = viewModel.errorPoints
    )

    //datum
    val calendar = Calendar.getInstance()
    data.date?.let {
        calendar.timeInMillis = it
    }

    val y = calendar.get(Calendar.YEAR)
    val m = calendar.get(Calendar.MONTH)
    val d = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { dialog: DatePicker, year: Int, month: Int, day: Int ->
            viewModel.onDateChange(DateUtils.getUnixTime(year, month, day))
        },
        y,
        m,
        d
    )

    InfoElement(
        value = if (data.date != null)
            DateUtils.getDateString(data.date!!) else null,
        label = stringResource(R.string.date),
        leadingIcon = R.drawable.ic_baseline_calendar_month_24,
        onClick = {
            datePickerDialog.show()
        },
        onClearClick = {
            viewModel.onDateChange(null)
        },
        error = viewModel.errorDate
    )

    OutlinedButton(
        onClick = { viewModel.save() }
    ) {
        Text(text = "Ulozit")
    }
}