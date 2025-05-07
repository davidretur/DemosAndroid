package com.dwr.demosmvvm.Domain

import com.dwr.demosmvvm.Data.Model.QuoteModel
import com.dwr.demosmvvm.Data.QuoteRepository
import com.dwr.demosmvvm.Domain.Model.Quote
import javax.inject.Inject


/**
 * GetRandomQuoteUseCase es una clase de caso de uso que recupera una cita al azar desde la base de datos.
 *
 * Esta clase utiliza inyección de dependencias para obtener una instancia del repositorio de citas.
 *
 * @author [David Duarte]
 * @version 1.0
 */
class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {
    /**
     * Obtiene una cita al azar desde la base de datos.
     *
     * @return Un objeto Quote representando la cita al azar, o null si no hay citas disponibles.
     */
    suspend operator fun invoke(): Quote? {
        // Obtenemos todas las citas desde el repositorio
        val quotes = repository.getAllQuotesFromDatabase()
        
        // Verificamos si hay citas disponibles
        if (!quotes.isNullOrEmpty()) {
            // Generamos un número aleatorio para seleccionar una cita al azar
            val randomNumber: Int = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}