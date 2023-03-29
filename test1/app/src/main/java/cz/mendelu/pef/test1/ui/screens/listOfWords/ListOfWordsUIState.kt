package cz.mendelu.pef.test1.ui.screens.listOfWords

import cz.mendelu.pef.test1.model.Word

sealed class ListOfWordsUIState {
    object Default : ListOfWordsUIState()
    class Success(val words: List<Word>) : ListOfWordsUIState()
}