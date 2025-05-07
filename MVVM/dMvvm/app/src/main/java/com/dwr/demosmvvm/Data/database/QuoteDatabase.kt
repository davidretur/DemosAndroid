package com.dwr.demosmvvm.Data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dwr.demosmvvm.Data.database.dao.QuoteDao
import com.dwr.demosmvvm.Data.database.entities.QuoteEntity

/**
 * QuoteDatabase es una clase abstracta que representa la base de datos SQLite para la aplicación.
 *
 * Esta clase utiliza Room, una biblioteca de persistencia de Android, para definir la estructura de la base de datos y sus operaciones.
 *
 * @author [David Duarte]
 * @version 1.0
 */
@Database(entities = [QuoteEntity::class], version = 1, exportSchema = false)
abstract class QuoteDatabase : RoomDatabase() {
    /**
     * Obtiene el dao para interactuar con las citas en la base de datos.
     *
     * @return Un objeto de tipo QuoteDao que permite realizar operaciones CRUD con las citas.
     */
    abstract fun getQuoteDao(): QuoteDao
}