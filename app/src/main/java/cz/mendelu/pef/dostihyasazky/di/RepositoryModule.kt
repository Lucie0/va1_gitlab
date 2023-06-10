package cz.mendelu.pef.dostihyasazky.di

import cz.mendelu.pef.dostihyasazky.database.cards.*
import org.koin.dsl.module

val repositoryModule = module {

    //metoda, ktera bude vracet instanci
    fun provideRepository(dao: RacesBetsDao): IRacesBetsRepository {
        return RacesBetsRepositoryImpl(dao)
    }

    // metoda
    single { provideRepository(get()) } // ziskani dao

}