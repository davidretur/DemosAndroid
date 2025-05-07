package com.dwr.demosmvvm.Domain

import com.dwr.demosmvvm.Data.QuoteRepository
import com.dwr.demosmvvm.Domain.Model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


/**
 * teniendo en cuenta que hay dos pruebas: una para cuando la base de datos está vacía y otra para cuando no está vacía.
 *
 * @author [David Duarte]
 * @version 1.0
 */
class GetRandomQuoteUseCaseTest {

    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository
    lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getRandomQuoteUseCase = GetRandomQuoteUseCase(quoteRepository)
    }

    /**
     * Prueba que verifica el comportamiento del sistema cuando la base de datos está vacía.
     */
    @Test
    fun `when database is empty then return null`() = runBlocking {
        //Given
        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns emptyList()
        //When
        val response = getRandomQuoteUseCase()
        //Then
        assert(response == null)
    }

    /**
     * Prueba que verifica el comportamiento del sistema cuando la base de datos no está vacía.
     */
    @Test
    fun `when database is not empty then return quote`() = runBlocking {
        //Given
        val quoteList = listOf(Quote("jarasho","Rusdev"))
        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns quoteList
        //When
        val response = getRandomQuoteUseCase()
        //Then
        assert(response == quoteList.first())
    }
}