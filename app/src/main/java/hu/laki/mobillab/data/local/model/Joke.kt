package hu.laki.mobillab.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import hu.laki.mobillab.domain.model.Joke as DomainJoke

@Entity
data class Joke(
        @PrimaryKey
        val id: String,
        val createdAt: String,
        val iconUrl: String,
        val updatedAt: String,
        val url: String,
        val value: String
)

fun DomainJoke.toLocalJoke(): Joke {
        return Joke(
                id = id,
                createdAt = createdAt,
                iconUrl = iconUrl,
                updatedAt = updatedAt,
                url = url,
                value = value
        )
}