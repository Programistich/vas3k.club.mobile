package club.vas3k.ui.decompose.statusbar

interface StatusBarIconStyleProvider {
    fun isStatusBarIconLight(systemIsDark: Boolean): Boolean
}
