package club.vas3k.app.backend.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Vas3kUserResponse(
    @SerialName("user")
    val user: Vas3kUser
)

@Serializable
data class Vas3kUser(
    @SerialName("id")
    val id: String,

    @SerialName("slug")
    val slug: String,
)
