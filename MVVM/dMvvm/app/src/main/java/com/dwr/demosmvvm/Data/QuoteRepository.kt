package com.dwr.demosmvvm.Data

import com.dwr.demosmvvm.Data.Model.QuoteModel
import com.dwr.demosmvvm.Data.Network.QuoteService
import com.dwr.demosmvvm.Data.database.dao.QuoteDao
import com.dwr.demosmvvm.Data.database.entities.QuoteEntity
import com.dwr.demosmvvm.Domain.Model.Quote
import com.dwr.demosmvvm.Domain.Model.toDomain
import javax.inject.Inject

/**
 * QuoteRepository es una clase que gestiona las operaciones de datos tanto desde la API como desde la base de datos.
 *
 * Esta clase se utiliza para obtener y gestionar citas en toda la aplicación.
 *
 * @author [David Duarte]
 * @version 1.0
 */
class QuoteRepository @Inject constructor(
    private val api : QuoteService,
    private val quoteDao: QuoteDao
) {
    /**
     * Obtiene todas las citas desde la API y las convierte a un formato de dominio.
     *
     * @return Una lista de citas en el formato de dominio.
     */
    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    /**
     * Obtiene todas las citas desde la base de datos y las convierte a un formato de dominio.
     *
     * @return Una lista de citas en el formato de dominio.
     */
    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response : List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map {  it.toDomain() }
    }

    /**
     * Inserta una lista de citas en la base de datos.
     *
     * @param quotes La lista de citas a insertar.
     */
    suspend fun insertQuotes(quotes: List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    /**
     * Elimina todas las citas de la base de datos.
     */
    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}