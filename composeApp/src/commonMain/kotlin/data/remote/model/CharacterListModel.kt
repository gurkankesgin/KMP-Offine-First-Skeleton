package data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterListModel(
    @SerialName("data") val data: List<Data>?,
)

@Serializable
data class Data(
    @SerialName("_id") val id: Int?,
    @SerialName("films") val films: List<String>?,
    @SerialName("shortFilms") val shortFilms: List<String>?,
    @SerialName("tvShows") val tvShows: List<String>?,
    @SerialName("imageUrl") val imageUrl: String?,
)