package cz.mendelu.pef.dostihyasazky.di

import cz.mendelu.pef.dostihyasazky.RacesAndBetsApp
import cz.mendelu.pef.dostihyasazky.database.cards.RacesBetsDatabase
import org.koin.dsl.module

val databaseModule = module {
    //metoda, ktera bude vracet instanci
    fun provideDatabase(): RacesBetsDatabase {
        return RacesBetsDatabase.getDatabase(RacesAndBetsApp.appContext)
    }

    single { provideDatabase() }
}