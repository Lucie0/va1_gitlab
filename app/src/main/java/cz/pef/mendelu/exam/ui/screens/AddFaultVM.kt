package cz.pef.mendelu.exam.ui.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import cz.pef.mendelu.exam.R
import cz.pef.mendelu.exam.architecture.BaseViewModel
import cz.pef.mendelu.exam.database.ILocalRepository
import cz.pef.mendelu.exam.model.Fault
import kotlinx.coroutines.launch

class AddFaultVM(private val repository: ILocalRepository) : BaseViewModel() {

    var data: Fault = Fault("", 0, null)

    var errorText: Int? = null
    var errorPoints: Int? = null
    var errorDate: Int? = null

    var uiState: MutableState<AddFaultUIState> = mutableStateOf(AddFaultUIState.Default)

    fun onTextChange(value: String) {
        data.text = value
        uiState.value = AddFaultUIState.Changed
    }

    fun onPointsChange(value: String) {
        // parsovani ze stringu do int
        data.points = parseStringToInt(value)
        uiState.value = AddFaultUIState.Changed
    }

    fun onDateChange(value: Long?) {
        data.date = value
        uiState.value = AddFaultUIState.Changed
    }

    fun save() {
        if (isValid()) {
            println(":) isValid")
            launch {
                // save
                repository.insert(item = data)
                // change uistate
                uiState.value = AddFaultUIState.Saved
            }
        } else {
            println(":) is not valid")
            // change uistate
            uiState.value = AddFaultUIState.Changed
        }
    }

    private fun isValid(): Boolean {
        var isValid = true

        errorText = null
        errorPoints = null
        errorDate = null

        if (data.text.isEmpty()) {
            isValid = false
            errorText = R.string.err_mandatory_field
        }

        if (data.points == 0 || data.points!! < 2 || data.points!! > 7) {
            isValid = false
            errorPoints = R.string.err_points_2__7
        }

        if (data.date == null) {
            isValid = false
            errorDate = R.string.err_mandatory_field
        }

        return isValid
    }

    private fun parseStringToInt(string: String): Int {
        var onlyDigits = true
        var result: Int = 0


        string.forEach {
            if (!it.isDigit()) {
                onlyDigits = false
            }
        }

        if (string.isNotEmpty() && onlyDigits && string.length <= 3) {
            result = string.toInt()
            uiState.value = AddFaultUIState.Changed
        } else if (string.isEmpty()) {
            result = 0
            errorPoints = R.string.err_mandatory_field
            uiState.value = AddFaultUIState.Changed
        } else if (string.length > 3) {
            result = 0
            errorPoints = R.string.err_too_big_number
            uiState.value = AddFaultUIState.Changed
        } else if (!onlyDigits) {
            result = 0
            errorPoints = R.string.err_must_not_have_letters
            uiState.value = AddFaultUIState.Changed
        }

        return result
    }

}