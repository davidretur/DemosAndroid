package com.dwr.demosmvvm.Data.Network

import com.dwr.demosmvvm.Data.Model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

/**
 * QuoteApiClient es una interfaz de cliente de API que define las operaciones para obtener citas.
 *
 * Esta interfaz utiliza Retrofit, una biblioteca de Android y Java para facilitar el consumo de servicios web RESTful.
 *
 * @author [Tu Nombre]
 * @version 1.0
 */
interface QuoteApiClient {
    /**
     * Obtiene todas las citas en formato JSON desde la API.
     *
     * @return Una respuesta asincrónica que contiene una lista de objetos QuoteModel.
     */
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}