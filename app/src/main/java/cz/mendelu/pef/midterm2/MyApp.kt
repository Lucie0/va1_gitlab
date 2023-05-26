package cz.mendelu.pef.midterm2

import android.app.Application
import android.content.Context
import cz.mendelu.pef.midterm2.di.daoModule
import cz.mendelu.pef.midterm2.di.databaseModule
import cz.mendelu.pef.midterm2.di.repositoryModule
import cz.mendelu.pef.midterm2.di.viewModelModule
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
