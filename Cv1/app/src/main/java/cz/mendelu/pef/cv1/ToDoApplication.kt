package cz.mendelu.pef.cv1

import android.app.Application
import android.content.Context
import cz.mendelu.pef.cv1.di.daoModule
import cz.mendelu.pef.cv1.di.databaseModule
import cz.mendelu.pef.cv1.di.repositoryModule
import cz.mendelu.pef.cv1.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ToDoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        startKoin{
            androidContext(this@ToDoApplication)
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