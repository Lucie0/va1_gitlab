package cz.mendelu.pef.mapappdistance

import android.app.Application
import android.content.Context
import cz.mendelu.pef.mapappdistance.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MapApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        startKoin{
            androidContext(this@MapApplication)
            modules(listOf(
                // seznam modulu
                // todo moduly
                viewModelModule,
//                repositoryModule,
//                daoModule,
//                databaseModule
            ))
        }
    }

    companion object {
        lateinit var appContext: Context private set // do contextu se NIKDY nesmi zapisovat

    }
}