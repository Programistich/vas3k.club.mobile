package club.vas3k.app.preference.api

import club.vas3k.app.preference.model.SettingsEnum
import club.vas3k.core.di.AppGraph
import me.tatarka.inject.annotations.Inject
import software.amazon.lastmile.kotlin.inject.anvil.ContributesBinding

@Inject
@ContributesBinding(AppGraph::class, ThemeStatusBarIconStyleProvider::class)
class ThemeStatusBarIconStyleProviderImpl(
    private val preferenceApi: PreferenceApi
) : ThemeStatusBarIconStyleProvider {
    override fun isStatusBarIconLight(systemIsDark: Boolean): Boolean {
        val isDark = preferenceApi.getBoolean(SettingsEnum.DARK_THEME, null)
        return when (isDark) {
            true -> true
            false -> false
            null -> systemIsDark
        }
    }
}
