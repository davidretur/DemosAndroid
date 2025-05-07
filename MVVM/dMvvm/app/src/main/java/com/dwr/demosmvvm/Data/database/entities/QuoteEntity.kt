package com.dwr.demosmvvm.Data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dwr.demosmvvm.Domain.Model.Quote

/**
 * QuoteEntity es una clase de datos (POJO) que representa una cita en la base de datos.
 *
 * Esta clase utiliza Room, una biblioteca de persistencia de Android, para definir la estructura de la tabla de citas en la base de datos.
 *
 * @author [David Duarte]
 * @version 1.0
 */
@Entity(tableName = "quote_table")
data class QuoteEntity(
    /**
     * El identificador único de la cita (auto-generado).
     */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,

    /**
     * El texto de la cita.
     */
    @ColumnInfo(name = "quote") val quote: String,

    /**
     * El autor de la cita.
     */
    @ColumnInfo(name = "author") val author: String
)

/**
 * Extensión de la clase Quote que convierte una instancia de Quote en una instancia de QuoteEntity.
 *
 * @param quote La instancia de Quote a convertir.
 * @return Una instancia de QuoteEntity con los mismos valores.
 */
fun Quote.toDatabase() = QuoteEntity(quote = quote, author = author)