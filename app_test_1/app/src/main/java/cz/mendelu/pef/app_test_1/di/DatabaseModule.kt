package cz.mendelu.pef.app_test_1.di

import cz.mendelu.pef.app_test_1.MyApp
import cz.mendelu.pef.app_test_1.database.MyDao
import cz.mendelu.pef.app_test_1.database.MyDatabase
import org.koin.dsl.module

val databaseModule = module {
    //metoda, ktera bude vracet instanci
    fun provideDatabase(): MyDatabase{
        return MyDatabase.getDatabase(MyApp.appContext)
    }

    single { provideDatabase() }
}


