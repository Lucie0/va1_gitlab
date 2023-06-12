package cz.pef.mendelu.exam.di

import cz.pef.mendelu.exam.database.ILocalRepository
import cz.pef.mendelu.exam.database.LocalRepositoryImpl
import cz.pef.mendelu.exam.database.TasksDao
import org.koin.dsl.module

val repositoryModule = module {

    //metoda, ktera bude vracet instanci
    fun provideRepository(dao: TasksDao): ILocalRepository {
        return LocalRepositoryImpl(dao)
    }

    single { provideRepository(get()) }
}