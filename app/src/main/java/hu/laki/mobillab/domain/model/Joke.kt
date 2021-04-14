package hu.laki.mobillab.domain.model

import hu.laki.mobillab.data.network.model.JokeDTO

data class Joke(
        val id: String,
        val createdAt: String,
        val iconUrl: String,
        val updatedAt: String,
        val url: String,
        val value: String
)

fun JokeDTO.toDomainJoke(jokeDTO: JokeDTO): Joke {
        return Joke(
                id = jokeDTO.id,
                createdAt = jokeDTO.createdAt,
                iconUrl = jokeDTO.iconUrl,
                updatedAt = jokeDTO.updatedAt,
                url = jokeDTO.url,
                value = jokeDTO.value
        )
}

