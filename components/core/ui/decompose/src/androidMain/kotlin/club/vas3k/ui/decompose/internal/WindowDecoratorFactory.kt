package club.vas3k.ui.decompose.internal

import club.vas3k.ui.decompose.AndroidWindowDecorator
import club.vas3k.ui.decompose.statusbar.StatusBarIconStyleProvider

internal actual fun createWindowDecorator(
    statusBarIconStyleProvider: StatusBarIconStyleProvider
): WindowDecorator = AndroidWindowDecorator(statusBarIconStyleProvider)
