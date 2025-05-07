package com.dwr.demosmvvm.Data.Network

import com.dwr.demosmvvm.Core.RetrofitHelper
import com.dwr.demosmvvm.Data.Model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * QuoteService es una clase que proporciona servicios relacionados con las citas.
 *
 * Esta clase utiliza Retrofit, una biblioteca de Android y Java para facilitar el consumo de servicios web RESTful.
 *
 * @author [David Duarte]
 * @version 1.0
 */
class QuoteService @Inject constructor(private val api: QuoteApiClient) {
    /**
     * Obtiene una lista de citas desde la API.
     *
     * @return Una lista de objetos QuoteModel representando las citas.
     */
    suspend fun getQuotes(): List<QuoteModel> {
        // Ejecutamos esta llamada en un hilo secundario (IO) usando Coroutines
        return withContext(Dispatchers.IO) {
            val response = api.getAllQuotes()
            // Verificamos si la respuesta contiene datos, de lo contrario devolvemos una lista vacía
            response.body() ?: emptyList()
        }
    }
}