package cz.mendelu.pef.midterm2.di

import cz.mendelu.pef.midterm2.ui.screens.AddPlayerVM
import cz.mendelu.pef.midterm2.ui.screens.PlayerOnMatchVM
import cz.mendelu.pef.midterm2.ui.screens.PlayersListVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        AddPlayerVM(get()) // getter na potrebny repository, vytvori ho a vrati ho sem
    }
    viewModel {
        PlayersListVM(get())
    }

    viewModel {
        PlayerOnMatchVM(get())
    }
}