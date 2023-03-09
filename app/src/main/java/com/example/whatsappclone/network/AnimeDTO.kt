package com.example.whatsappclone.network

data class AnimeListDTO(
    val data: List<AnimeDTO>
)

data class AnimeDTO(
    val id: String,
    val type: String,
    val attributes: AnimeAttributeDTO
)

data class AnimeAttributeDTO(
    val slug: String,
    val description: String,
    val averageRating: String,
    val posterImage: AnimePosterImageDTO
)

data class AnimePosterImageDTO(
    val medium: String,
    val original: String,
)
