package cz.mendelu.pef.test1.di

import cz.mendelu.pef.test1.database.WordsDao
import cz.mendelu.pef.test1.database.WordsDatabase
import org.koin.dsl.module

val daoModule = module {

    //metoda, ktera bude vracet instanci
    fun provideDao(database: WordsDatabase) : WordsDao {// resim pouze, co vracim a co k tomu potrebuju
        return database.wordsDao()
    }

    single { provideDao(get()) }
}