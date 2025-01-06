package club.vas3k.app.di

import club.vas3k.app.preference.api.PreferenceApi
import club.vas3k.app.root.api.RootDecomposeComponent
import com.russhwolf.settings.ObservableSettings
import kotlinx.coroutines.CoroutineScope
import me.tatarka.inject.annotations.Provides

interface AppComponent {
    @get:Provides val observableSettings: ObservableSettings

    @get:Provides val scope: CoroutineScope

    val rootDecomposeComponentFactory: RootDecomposeComponent.Factory

    val preferenceApi: PreferenceApi
}
