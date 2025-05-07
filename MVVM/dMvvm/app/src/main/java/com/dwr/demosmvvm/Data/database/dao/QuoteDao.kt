package com.dwr.demosmvvm.Data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dwr.demosmvvm.Data.database.entities.QuoteEntity
import com.dwr.demosmvvm.Domain.Model.Quote

/**
 * QuoteDao es una interfaz que define las operaciones de acceso a datos (DAO) para interactuar con la tabla de citas en la base de datos.
 *
 * Esta interfaz utiliza Room, una biblioteca de persistencia de Android, para definir consultas y operaciones CRUD con las citas.
 *
 * @author [David Duarte]
 * @version 1.0
 */
@Dao
public interface QuoteDao {
    /**
     * Obtiene todas las citas de la base de datos ordenadas por el autor en orden descendente.
     *
     * @return Una lista de objetos QuoteEntity representando las citas.
     */
    @Query("SELECT * FROM quote_table ORDER BY author DESC")
    suspend fun getAllQuotes(): List<QuoteEntity>

    /**
     * Inserta una lista de citas en la base de datos, reemplazando cualquier conflicto con estrategia REPLACE.
     *
     * @param quotes La lista de objetos QuoteEntity a insertar.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes: List<QuoteEntity>)

    /**
     * Elimina todas las citas de la base de datos.
     */
    @Query("DELETE FROM quote_table")
    suspend fun deleteAllQuotes()
}