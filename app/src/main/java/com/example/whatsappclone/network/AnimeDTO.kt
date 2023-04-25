package com.example.whatsappclone.network

//data class AnimeListDTO(
//    val articles: List<AnimeDTO>
//)
//
//data class AnimeDTO(
//    val id: String,
//    val type: String,
//    val attributes: AnimeAttributeDTO
//)
//
//data class AnimeAttributeDTO(
//    val slug: String,
//    val description: String,
//    val averageRating: String,
//    val posterImage: AnimePosterImageDTO
//)
//
//data class AnimePosterImageDTO(
//    val medium: String,
//    val original: String,
//)

//----------------------------------------------------------------------------------------
//data class AnimeListDTO(
//    val articles: List<AnimeDTO>
//)

//data class AnimeDTO(
//    val id: Int,
//    val title: String,
//    val newsSite: String,
//    val imageUrl: String,
//    val updatedAt: String
//)

//----------------------------------------------------------------------------------------

data class AnimeListDTO(
    val users: List<AnimeDTO>
)
data class AnimeDTO(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val birthDate: String,
    val image: String,
    val address: AddressDTO
)

data class AddressDTO(
    val address: String,
    val city: String
)