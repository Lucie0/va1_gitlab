package cz.mendelu.pef.test1.di

//import cz.mendelu.pef.cv1.ui.screens.addEditTask.AddEditTaskViewModel
//import cz.mendelu.pef.cv1.ui.screens.taskList.TaskListViewModel
import cz.mendelu.pef.test1.ui.screens.addItem.AddItemViewModel
import cz.mendelu.pef.test1.ui.screens.listOfWords.ListOfWordsViewModel
import cz.mendelu.pef.test1.ui.screens.mainScreen.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

// inicializace modulu pouze pomoci viewModel
val viewModelModule = module {
    viewModel{
        MainScreenViewModel(get()) // getter na potrebny repository, vytvori ho a vrati ho sem
    }
    viewModel {
        AddItemViewModel(get())
    }

    viewModel {
        ListOfWordsViewModel(get())
    }
}