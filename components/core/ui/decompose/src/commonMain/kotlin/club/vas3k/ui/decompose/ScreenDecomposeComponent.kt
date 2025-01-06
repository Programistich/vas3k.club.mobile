package club.vas3k.ui.decompose

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.Lifecycle
import club.vas3k.ui.decompose.internal.WindowDecorator
import club.vas3k.ui.decompose.internal.createWindowDecorator
import club.vas3k.ui.decompose.statusbar.StatusBarIconStyleProvider

abstract class ScreenDecomposeComponent(
    componentContext: ComponentContext
) : club.vas3k.ui.decompose.DecomposeComponent(),
    ComponentContext by componentContext,
    Lifecycle.Callbacks,
    StatusBarIconStyleProvider {
    private val windowDecorator: WindowDecorator by lazy {
        createWindowDecorator(statusBarIconStyleProvider = this)
    }

    init {
        lifecycle.subscribe(this)
    }

    override fun onResume() {
        super.onResume()
        windowDecorator.decorate()
    }

    override fun isStatusBarIconLight(systemIsDark: Boolean) = false
}
