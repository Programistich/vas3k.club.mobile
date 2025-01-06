package club.vas3k.app

import android.app.Application
import club.vas3k.app.di.AndroidAppComponent
import club.vas3k.app.di.create
import club.vas3k.core.activityholder.CurrentActivityHolder
import club.vas3k.core.di.AndroidPlatformDependencies
import club.vas3k.core.di.ComponentHolder
import club.vas3k.core.ktx.common.AppDispatchers
import com.russhwolf.settings.SharedPreferencesSettings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import timber.log.Timber

class Vas3kApplication : Application() {
    private val settings by lazy {
        SharedPreferencesSettings(
            baseContext.getSharedPreferences(
                "settings",
                MODE_PRIVATE
            )
        )
    }
    private val applicationScope = CoroutineScope(
        SupervisorJob() + AppDispatchers.default
    )

    override fun onCreate() {
        super.onCreate()

        CurrentActivityHolder.register(this)

        ComponentHolder.components += AndroidAppComponent::class.create(
            settings,
            applicationScope,
            this@Vas3kApplication,
            AndroidPlatformDependencies(MainActivity::class)
        )

        Timber.plant(Timber.DebugTree())
    }
}
