package cz.mendelu.pef.test1.ui.screens.listOfWords

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cz.mendelu.pef.test1.architecture.BaseViewModel
import cz.mendelu.pef.test1.database.IWordsRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ListOfWordsViewModel(private val repository: IWordsRepository)
    : BaseViewModel() {
    // todo
    val wordListUIState: MutableState<ListOfWordsUIState> =
        mutableStateOf(ListOfWordsUIState.Default)

    fun loadWords() {
        launch {
            repository.getAll().collect() {
                wordListUIState.value = ListOfWordsUIState.Success(it)
            }
        }
    }
}