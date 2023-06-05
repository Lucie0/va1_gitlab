package cz.mendelu.pef.hw2.di


import cz.mendelu.pef.app_test_1.database.MyDatabase
import cz.mendelu.pef.hw2.MyApp
import org.koin.dsl.module

val databaseModule = module {
    //metoda, ktera bude vracet instanci
    fun provideDatabase(): MyDatabase{
        return MyDatabase.getDatabase(MyApp.appContext)
    }

    single { provideDatabase() }
}


