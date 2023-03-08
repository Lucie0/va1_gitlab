package cz.mendelu.pef.cv1.di

import cz.mendelu.pef.cv1.database.TasksDao
import cz.mendelu.pef.cv1.database.TasksDatabase
import org.koin.dsl.module

val daoModule = module {

    //metoda, ktera bude vracet instanci
    fun provideDao(database: TasksDatabase) : TasksDao {// resim pouze, co vracim a co k tomu potrebuju
        return database.tasksDao()
    }

    single { provideDao(get()) }
}