package cz.pef.mendelu.exam.di

import cz.pef.mendelu.exam.MyApp
import cz.pef.mendelu.exam.database.TasksDatabase
import org.koin.dsl.module

val databaseModule = module {
    //metoda, ktera bude vracet instanci
    fun provideDatabase(): TasksDatabase{
        return TasksDatabase.getDatabase(MyApp.appContext)
    }

    single { provideDatabase() }
}
