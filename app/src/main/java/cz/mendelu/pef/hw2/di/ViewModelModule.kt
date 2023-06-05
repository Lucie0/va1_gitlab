package cz.mendelu.pef.hw2.di

import cz.mendelu.pef.hw2.ui.screens.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

// inicializace modulu pouze pomoci viewModel
val viewModelModule = module {
    viewModel {
        AddContactVM(get()) // getter na potrebny repository, vytvori ho a vrati ho sem
    }

    viewModel {
        ContactsListVM(get())
    }
}
