package cz.mendelu.pef.test1.ui.screens.addItem

import cz.mendelu.pef.test1.architecture.BaseViewModel
import cz.mendelu.pef.test1.database.IWordsRepository
import cz.mendelu.pef.test1.model.Word
import cz.mendelu.pef.test1.ui.screens.addItem.AddItemActions
import kotlinx.coroutines.launch

class AddItemViewModel(private val repository: IWordsRepository)
    : BaseViewModel(), AddItemActions {
    override fun saveWord(cz_word: String, en_word: String) {
        launch {
//            val id = repository.insert(Word())
            // ulozeni do db
        }
    }

}