package cz.pef.mendelu.exam.ui.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import cz.pef.mendelu.exam.architecture.BaseViewModel
import cz.pef.mendelu.exam.database.ILocalRepository
import cz.pef.mendelu.exam.model.Fault
import cz.pef.mendelu.exam.ui.utils.DateUtils
import kotlinx.coroutines.launch

class FaultsListVM(private val repository: ILocalRepository) : BaseViewModel() {

    var uiState: MutableState<FaultsListUIState> = mutableStateOf(FaultsListUIState.Default)
    var sumPoints = 0
    var color = Color.Black
    var font = FontWeight.Normal

    var beforeYear = DateUtils.getUnixTime(2022,6,12)


    fun load() {
        launch {
            repository.getActualFaults(beforeYear)
                .collect() {
                    uiState.value = FaultsListUIState.Success(it)
                    countPointsAndColorIt(it)
                }
        }
    }

    private fun countPointsAndColorIt(items: List<Fault>) {
        var sum = 0

        items.forEach {
            sum += it.points!!
        }
        sumPoints = sum

        if (sumPoints > 12) {
            color = Color.Red
            font = FontWeight.Bold
        } else {
            color = Color.Black
            font = FontWeight.Normal
        }
    }

}