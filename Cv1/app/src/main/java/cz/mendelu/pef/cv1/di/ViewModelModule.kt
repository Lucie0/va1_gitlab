package cz.mendelu.pef.cv1.di

import cz.mendelu.pef.cv1.ui.screens.addEditTask.AddEditTaskViewModel
import cz.mendelu.pef.cv1.ui.screens.taskList.TaskListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

// inicializace modulu pouze pomoci viewModel
val viewModelModule = module {
    viewModel{
        TaskListViewModel(get()) // getter na potrebny repository, vytvori ho a vrati ho sem
    }
    viewModel {
        AddEditTaskViewModel(get())
    }
}