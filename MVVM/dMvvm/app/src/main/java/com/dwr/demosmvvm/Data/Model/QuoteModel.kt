package com.dwr.demosmvvm.Data.Model

import com.google.gson.annotations.SerializedName

/**
 * QuoteModel es una clase de datos (POJO) que representa un modelo de cita.
 *
 * Esta clase se utiliza para reformatear los resultados de una API, asegurándose de que los campos coincidan con las propiedades definidas en la clase.
 *
 * @author [Tu Nombre]
 * @version 1.0
 */
data class QuoteModel(
    /**
     * El texto de la cita.
     */
    val quote: String,

    /**
     * El autor de la cita.
     */
    val author: String
)