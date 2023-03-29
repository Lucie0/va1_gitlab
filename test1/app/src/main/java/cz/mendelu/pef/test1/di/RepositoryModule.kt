package cz.mendelu.pef.test1.di

import cz.mendelu.pef.test1.database.IWordsRepository
import cz.mendelu.pef.test1.database.WordsDao
import cz.mendelu.pef.test1.database.WordsRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    //metoda, ktera bude vracet instanci
    fun provideTasksRepository(dao: WordsDao): IWordsRepository{
        return WordsRepositoryImpl(dao)
        // todo
    }

    // metoda
    single { provideTasksRepository(get()) } // ziskani dao

}