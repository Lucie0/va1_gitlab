package cz.mendelu.pef.cv1.di

import cz.mendelu.pef.cv1.ToDoApplication
import cz.mendelu.pef.cv1.database.TasksDatabase
import org.koin.dsl.module

val databaseModule = module {
    fun provideDatabase(): TasksDatabase{
        return TasksDatabase.getDatabase(ToDoApplication.appContext)
    }

    single { provideDatabase() }
}
