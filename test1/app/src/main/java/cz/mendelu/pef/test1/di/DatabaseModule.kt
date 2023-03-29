package cz.mendelu.pef.test1.di

import cz.mendelu.pef.test1.WordsApplication
import cz.mendelu.pef.test1.database.WordsDatabase
import org.koin.dsl.module

val databaseModule = module {
    //metoda, ktera bude vracet instanci
    fun provideDatabase(): WordsDatabase{
        return WordsDatabase.getDatabase(WordsApplication.appContext)
    }

    single { provideDatabase() }
}
