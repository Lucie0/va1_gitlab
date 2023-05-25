package cz.mendelu.pef.app_test_1

import android.app.Application
import android.content.Context
import cz.mendelu.pef.app_test_1.di.daoModule
import cz.mendelu.pef.app_test_1.di.databaseModule
import cz.mendelu.pef.app_test_1.di.repositoryModule
import cz.mendelu.pef.app_test_1.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        startKoin{
            androidContext(this@MyApp)
            modules(listOf(
                // seznam modulu
                // todo moduly
                viewModelModule,
                repositoryModule,
                daoModule,
                databaseModule
            ))
        }
    }

    companion object {
        lateinit var appContext: Context private set // do contextu se NIKDY nesmi zapisovat

    }
}
