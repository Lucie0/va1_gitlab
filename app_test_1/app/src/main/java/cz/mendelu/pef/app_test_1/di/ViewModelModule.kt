package cz.mendelu.pef.app_test_1.di

import cz.mendelu.pef.app_test_1.ui.screens.AddCarVM
import cz.mendelu.pef.app_test_1.ui.screens.CarListVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

// inicializace modulu pouze pomoci viewModel
val viewModelModule = module {
    viewModel {
        AddCarVM(get()) // getter na potrebny repository, vytvori ho a vrati ho sem
    }

    viewModel {
        CarListVM(get())
    }
}
