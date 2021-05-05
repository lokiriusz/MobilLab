package hu.laki.mobillab.mock.domain

import hu.laki.mobillab.domain.model.Joke

fun mockJoke(): Joke {
    return mockJokeWith("qj8WlWyzSFiRZzl60ZsuJw")
}

fun mockJokeWith(id: String): Joke {
    return Joke(
        id = id,
        createdAt = "2020-01-05 13:42:24.40636",
        iconUrl = "https://assets.chucknorris.host/img/avatar/chuck-norris.png",
        updatedAt = "2020-01-05 13:42:24.40636",
        url = "https://api.chucknorris.io/jokes/qj8WlWyzSFiRZzl60ZsuJw",
        value = "When Chuck Norris exercises the machine gets stronger."
    )
}