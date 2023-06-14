package cz.mendelu.pef.dostihyasazky


import android.app.Application
import android.content.Context
import cz.mendelu.pef.dostihyasazky.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RacesAndBetsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        startKoin{
            androidContext(this@RacesAndBetsApp)
            modules(listOf(
                // seznam modulu
                // todo moduly
                viewModelModule,
                repositoryModule,
                daoModule,
                databaseModule,
                dataStoreModule
            ))
        }
    }

    companion object {
        lateinit var appContext: Context private set // do contextu se NIKDY nesmi zapisovat

    }
}
