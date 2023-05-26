package cz.mendelu.pef.midterm2.di

import cz.mendelu.pef.midterm2.database.MyDao
import cz.mendelu.pef.midterm2.database.MyDatabase
import org.koin.dsl.module

val daoModule = module {

    //metoda, ktera bude vracet instanci
    fun provideDao(database: MyDatabase) : MyDao {// resim pouze, co vracim a co k tomu potrebuju
        return database.myDao()
    }

    single { provideDao(get()) }
}
