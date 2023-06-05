package cz.mendelu.pef.hw2.di

import cz.mendelu.pef.hw2.database.IRepository
import cz.mendelu.pef.hw2.database.MyDao
import cz.mendelu.pef.hw2.database.RepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    //metoda, ktera bude vracet instanci
    fun provideRepository(dao: MyDao): IRepository {
        return RepositoryImpl(dao)
    }

    // metoda
    single { provideRepository(get()) } // ziskani dao

}
