package club.vas3k.app.backend.api

import club.vas3k.app.backend.model.Vas3kUserResponse

interface Vas3kClubAPI {
    suspend fun getUser(): Result<Vas3kUserResponse>

    fun getAuthUrl(): String
    suspend fun auth(pkceCode: String): Result<Unit>
}