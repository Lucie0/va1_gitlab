package cz.mendelu.pef.mapappdistance.di

import cz.mendelu.pef.mapappdistance.ui.screens.choosePoint.ChoosePointMapViewModel
import cz.mendelu.pef.mapappdistance.ui.screens.showDistance.ShowDistanceMapViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{
        ChoosePointMapViewModel()
    }

    viewModel {
        ShowDistanceMapViewModel()
    }
}