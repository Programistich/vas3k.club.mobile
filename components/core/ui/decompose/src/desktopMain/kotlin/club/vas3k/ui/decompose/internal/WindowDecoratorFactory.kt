package club.vas3k.ui.decompose.internal

import club.vas3k.ui.decompose.statusbar.StatusBarIconStyleProvider

internal actual fun createWindowDecorator(
    statusBarIconStyleProvider: StatusBarIconStyleProvider
): WindowDecorator = club.vas3k.ui.decompose.internal.DesktopWindowDecorator()
