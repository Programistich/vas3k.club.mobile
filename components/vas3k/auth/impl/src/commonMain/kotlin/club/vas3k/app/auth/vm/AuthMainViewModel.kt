package club.vas3k.app.auth.vm

import club.vas3k.app.backend.api.Vas3kClubAPI
import club.vas3k.core.log.LogTagProvider
import club.vas3k.core.ui.lifecycle.DecomposeViewModel
import me.tatarka.inject.annotations.Inject

@Inject
class AuthMainViewModel(
    private val vas3kClubAPI: Vas3kClubAPI
) : DecomposeViewModel(), LogTagProvider {
    override val TAG = "AuthMainViewModel"
}
