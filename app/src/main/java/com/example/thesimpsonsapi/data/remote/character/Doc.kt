package com.example.thesimpsonsapi.data.remote.character

import com.example.thesimpsonsapi.data.Character

data class Doc(
    val Estado: String,
    val Genero: String,
    val Historia: String,
    val Imagen: String,
    val Nombre: String,
    val Ocupacion: String,
    val _id: String,
    val updatedAt: String
) {
    fun toCharacter() = Character(
        name = Nombre,
        history = Historia,
        urlImage = Imagen
    )
}