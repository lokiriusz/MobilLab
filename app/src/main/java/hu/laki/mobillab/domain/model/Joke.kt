package hu.laki.mobillab.domain.model

import hu.laki.mobillab.data.network.model.JokeDTO
import hu.laki.mobillab.data.local.model.Joke as LocalJoke

data class Joke(
        val id: String,
        val createdAt: String,
        val iconUrl: String,
        val updatedAt: String,
        val url: String,
        val value: String
)

fun JokeDTO.toDomainJoke(): Joke {
        return Joke(
                id = id,
                createdAt = createdAt,
                iconUrl = iconUrl,
                updatedAt = updatedAt,
                url = url,
                value = value
        )
}

fun LocalJoke.toDomainJoke(): Joke {
        return Joke(
                id = id,
                createdAt = createdAt,
                iconUrl = iconUrl,
                updatedAt = updatedAt,
                url = url,
                value = value
        )
}
