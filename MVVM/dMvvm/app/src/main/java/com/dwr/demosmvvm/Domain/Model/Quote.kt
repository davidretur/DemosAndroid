package com.dwr.demosmvvm.Domain.Model

import com.dwr.demosmvvm.Data.Model.QuoteModel
import com.dwr.demosmvvm.Data.database.entities.QuoteEntity

/**
 * Quote es una clase de datos que representa una cita.
 *
 * @author [Tu Nombre]
 * @version 1.0
 */
data class Quote(
    val quote: String,
    val author: String
)

/**
 * Extension function que convierte un objeto QuoteModel a un objeto Quote de dominio.
 *
 * @return Un objeto Quote representando la cita en formato de dominio.
 */
fun QuoteModel.toDomain() = Quote(quote, author)

/**
 * Extension function que convierte un objeto QuoteEntity a un objeto Quote de dominio.
 *
 * @return Un objeto Quote representando la cita en formato de dominio.
 */
fun QuoteEntity.toDomain() = Quote(quote, author)