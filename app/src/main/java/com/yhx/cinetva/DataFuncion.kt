package com.yhx.cinetva

import java.io.Serializable

data class DataFuncion(
    val no: Int,
    val hora: String,
    val fecha: String,
    val pelicula: Int,
    val sala: Int
) :Serializable
