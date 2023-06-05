package cz.mendelu.pef.hw2.di

import cz.mendelu.pef.app_test_1.database.MyDatabase
import cz.mendelu.pef.hw2.database.MyDao
import org.koin.dsl.module

val daoModule = module {

    //metoda, ktera bude vracet instanci
    fun provideDao(database: MyDatabase) : MyDao {// resim pouze, co vracim a co k tomu potrebuju
        return database.myDao()
    }

    single { provideDao(get()) }
}
