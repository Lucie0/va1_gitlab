package cz.mendelu.pef.dostihyasazky.di

import cz.mendelu.pef.dostihyasazky.database.RacesBetsDao
import cz.mendelu.pef.dostihyasazky.database.RacesBetsDatabase
import org.koin.dsl.module

val daoModule = module {

    //metoda, ktera bude vracet instanci
    fun provideDao(database: RacesBetsDatabase) : RacesBetsDao {// resim pouze, co vracim a co k tomu potrebuju
        return database.rbDao()
    }

    single { provideDao(get()) }
}