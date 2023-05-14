package cz.mendelu.pef.mapappdistance.di

import cz.mendelu.pef.mapappdistance.ui.screens.choosePoint.ChoosePointMapViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{
        ChoosePointMapViewModel()
    }
}