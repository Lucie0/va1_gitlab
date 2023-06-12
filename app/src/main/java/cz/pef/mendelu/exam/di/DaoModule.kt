package cz.pef.mendelu.exam.di

import cz.pef.mendelu.exam.database.TasksDao
import cz.pef.mendelu.exam.database.TasksDatabase
import org.koin.dsl.module

val daoModule = module {
    //metoda, ktera bude vracet instanci
    fun provideDao(database: TasksDatabase) : TasksDao {
        return database.myDao()
    }

    single { provideDao(get()) }
}
