package cz.mendelu.pef.cv1.di

import cz.mendelu.pef.cv1.database.ITasksRepository
import cz.mendelu.pef.cv1.database.TasksDao
import cz.mendelu.pef.cv1.database.TasksRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    //metoda, ktera bude vracet instanci
    fun provideTasksRepository(dao: TasksDao): ITasksRepository{
        return TasksRepositoryImpl(dao)
    }

    // metoda
    single { provideTasksRepository(get()) } // ziskani dao

}