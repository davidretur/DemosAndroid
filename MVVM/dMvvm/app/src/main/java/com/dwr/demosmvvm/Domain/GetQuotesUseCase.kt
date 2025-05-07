package com.dwr.demosmvvm.Domain
import com.dwr.demosmvvm.Data.QuoteRepository
import com.dwr.demosmvvm.Data.database.entities.toDatabase
import com.dwr.demosmvvm.Domain.Model.Quote
import javax.inject.Inject

/**
 * GetQuotesUseCase es una clase de caso de uso que recupera una lista de citas.
 *
 * Esta clase utiliza inyección de dependencias para obtener una instancia del repositorio de citas.
 *
 * @author [David Duarte]
 * @version 1.0
 */
class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {
    /**
     * Obtiene una lista de citas desde la API y las almacena en la base de datos si es necesario.
     *
     * @return Una lista de objetos Quote representando las citas, o una lista vacía si no hay citas disponibles.
     */
    suspend operator fun invoke(): List<Quote> {
        // Obtenemos todas las citas desde la API
        val quotes = repository.getAllQuotesFromApi()
        
        // Verificamos si hay citas disponibles
        if (quotes.isNotEmpty()) {
            // Limpiamos cualquier dato previo en la base de datos
            repository.clearQuotes()
            // Insertamos las nuevas citas en la base de datos
            repository.insertQuotes(quotes.map { it.toDatabase() })
            return quotes
        } else {
            // Si no hay citas en la API, obtenemos las citas desde la base de datos
            return repository.getAllQuotesFromDatabase()
        }
    }
}