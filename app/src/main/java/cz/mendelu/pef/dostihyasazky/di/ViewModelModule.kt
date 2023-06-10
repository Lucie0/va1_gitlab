package cz.mendelu.pef.dostihyasazky.di

import cz.mendelu.pef.dostihyasazky.ui.screens.game.GameScreenVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        GameScreenVM() // todo get()) // getter na repository
    }

//    viewModel {
//        ContactsListVM(get())
//    }
}
