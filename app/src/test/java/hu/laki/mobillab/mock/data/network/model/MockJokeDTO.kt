package hu.laki.mobillab.mock.data.network.model

import hu.laki.mobillab.data.network.model.JokeDTO

fun mockJokeDTO(): JokeDTO {
    return mockJokeDTOWith("qj8WlWyzSFiRZzl60ZsuJw")
}

fun mockJokeDTOWith(id: String): JokeDTO {
    return JokeDTO(
        id = id,
        createdAt = "2020-01-05 13:42:24.40636",
        iconUrl = "https://assets.chucknorris.host/img/avatar/chuck-norris.png",
        updatedAt = "2020-01-05 13:42:24.40636",
        url = "https://api.chucknorris.io/jokes/qj8WlWyzSFiRZzl60ZsuJw",
        value = "When Chuck Norris exercises the machine gets stronger."
    )
}