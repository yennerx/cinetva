package com.yhx.cinetva

import java.io.Serializable

data class DataSala(
    val no:Int,
    val capacidad: Int,
    val ocupados: Int,
    val categoria: String,
    val pelicula: Int
): Serializable
