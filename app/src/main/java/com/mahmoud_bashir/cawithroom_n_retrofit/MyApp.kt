package com.mahmoud_bashir.cawithroom_n_retrofit

import android.app.Application
import com.mahmoud_bashir.cawithroom_n_retrofit.data.di.dataModule
import com.mahmoud_bashir.cawithroom_n_retrofit.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(
                listOf(appModule, dataModule)
            )
        }
    }
}