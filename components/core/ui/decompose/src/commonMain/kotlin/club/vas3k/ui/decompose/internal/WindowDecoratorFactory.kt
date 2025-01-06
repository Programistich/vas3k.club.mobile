package club.vas3k.ui.decompose.internal

import club.vas3k.ui.decompose.statusbar.StatusBarIconStyleProvider

internal expect fun createWindowDecorator(
    statusBarIconStyleProvider: StatusBarIconStyleProvider
): WindowDecorator
