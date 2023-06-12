package cz.pef.mendelu.exam.di

import cz.pef.mendelu.exam.ui.screens.AddFaultVM
import cz.pef.mendelu.exam.ui.screens.FaultsListVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    // todo pridat VMs
    viewModel {
        AddFaultVM(get()) // getter na potrebny repository, vytvori ho a vrati ho sem
    }

    viewModel {
        FaultsListVM(get())
    }
}