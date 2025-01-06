package ${packageName}.api

import com.arkivanov.decompose.ComponentContext
import club.vas3k.ui.decompose.ScreenDecomposeComponent

abstract class ${__formattedModuleName}ScreenDecomposeComponent(
    componentContext: ComponentContext
) : ScreenDecomposeComponent(componentContext) {
    fun interface Factory {
        operator fun invoke(
            componentContext: ComponentContext,
        ): ${__formattedModuleName}ScreenDecomposeComponent
    }
}
