package cz.mendelu.pef.test1

import android.app.Application
import android.content.Context
import cz.mendelu.pef.test1.di.daoModule
import cz.mendelu.pef.test1.di.databaseModule
import cz.mendelu.pef.test1.di.repositoryModule
import cz.mendelu.pef.test1.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WordsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        startKoin{
            androidContext(this@WordsApplication)
            modules(listOf(
                // seznam modulu
                // todo moduly
                daoModule,
                repositoryModule,
                databaseModule,
                viewModelModule
            ))
        }
    }

    companion object {
        lateinit var appContext: Context private set

    }

}