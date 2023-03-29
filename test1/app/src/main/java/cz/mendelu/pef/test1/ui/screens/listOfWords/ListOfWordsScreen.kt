package cz.mendelu.pef.test1.ui.screens.listOfWords

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cz.mendelu.pef.test1.model.Word
import cz.mendelu.pef.test1.navigation.INavigationRouter
import cz.mendelu.pef.test1.ui.elements.BackArrowScreen
import org.koin.androidx.compose.getViewModel

@Composable
fun ListOfWordsScreen(navigation: INavigationRouter,
    viewModel: ListOfWordsViewModel = getViewModel()){

    var words = remember {
        mutableStateListOf<Word>()
    }

    viewModel.wordListUIState.value.let {
        when(it){
            ListOfWordsUIState.Default -> {
                viewModel.loadWords()
            }
            is ListOfWordsUIState.Success -> {
                words.clear()
                words.addAll(it.words)
            }
        }
    }

    BackArrowScreen(
        appBarTitle = "List Of Words",
        onBackClick = {
//            navigation.navigateBack()
        }) {
        ListOfWordsScreenContent(it, words)
    }
}

@Composable
fun ListOfWordsScreenContent(paddingValues: PaddingValues, words: MutableList<Word>) {
    LazyColumn(modifier = Modifier.padding(paddingValues)) {
        // todo list of words from db
        words.forEach{
            item(key = it.id){
                it
            }
        }

//        tasks.forEach{
//            item(key = it.id) { // aby se nerefreshovaly zaznamy, ktere jsou stale stejne, predani jedinecneho id
//                TaskRow(
//                    task = it,
//                    onRowClick = { navigation.navigateToAddEditTaskScreen(it.id) },
//                    actions = actions)
//            }
//        }
    }

}
