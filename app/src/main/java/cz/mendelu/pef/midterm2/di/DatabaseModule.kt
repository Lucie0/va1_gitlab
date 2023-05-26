package cz.mendelu.pef.midterm2.di

import cz.mendelu.pef.midterm2.MyApp
import cz.mendelu.pef.midterm2.database.MyDatabase
import org.koin.dsl.module

val databaseModule = module {
    //metoda, ktera bude vracet instanci
    fun provideDatabase(): MyDatabase {
        return MyDatabase.getDatabase(MyApp.appContext)
    }

    single { provideDatabase() }
}
