package hu.laki.mobillab.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

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