package club.vas3k.app.di

import club.vas3k.core.di.AppGraph
import com.russhwolf.settings.ObservableSettings
import kotlinx.coroutines.CoroutineScope
import software.amazon.lastmile.kotlin.inject.anvil.MergeComponent
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

@MergeComponent(AppGraph::class)
@SingleIn(AppGraph::class)
abstract class DesktopAppComponent(
    override val observableSettings: ObservableSettings,
    override val scope: CoroutineScope
) : AppComponent
