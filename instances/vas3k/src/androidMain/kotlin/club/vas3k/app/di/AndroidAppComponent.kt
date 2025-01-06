package club.vas3k.app.di

import android.content.Context
import club.vas3k.core.di.AndroidPlatformDependencies
import club.vas3k.core.di.AppGraph
import com.russhwolf.settings.ObservableSettings
import kotlinx.coroutines.CoroutineScope
import me.tatarka.inject.annotations.Provides
import software.amazon.lastmile.kotlin.inject.anvil.MergeComponent
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

@MergeComponent(AppGraph::class)
@SingleIn(AppGraph::class)
abstract class AndroidAppComponent(
    override val observableSettings: ObservableSettings,
    override val scope: CoroutineScope,
    @get:Provides val context: Context,
    @get:Provides val dependencies: AndroidPlatformDependencies
) : AppComponent
