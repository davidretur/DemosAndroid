package com.dwr.demosmvvm.Domain

import com.dwr.demosmvvm.Data.QuoteRepository
import com.dwr.demosmvvm.Domain.Model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


/**
 * Clase de prueba para el caso de uso de obtención de citas (GetQuotesUseCase).
 *
 * Esta clase contiene pruebas unitarias para verificar el comportamiento de GetQuotesUseCase,
 * que se encarga de obtener citas desde la API o la base de datos según la respuesta de la API.
 */
class GetQuotesUseCaseTest {

    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository
    private lateinit var getQuotesUseCase: GetQuotesUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getQuotesUseCase = GetQuotesUseCase(quoteRepository)
    }

    /**
     * Prueba que cuando la API no devuelve nada, se obtienen los valores de la base de datos.
     */
    @Test
    fun `when The Api Doesnt Return Anything Then Get Values From Database`() = runBlocking {
        //given
        coEvery { quoteRepository.getAllQuotesFromApi() }.returns(emptyList())
        //when
        // llamada a caso de uso
        getQuotesUseCase()
        //then
        // verificamos que se llame a la funcion getAllQuotesFromDatabase()
        coVerify(exactly = 1) { quoteRepository.getAllQuotesFromDatabase() }
    }

    /**
     * Prueba que cuando la API devuelve algo, se obtienen los valores de la API.
     *
     * También verifica que se limpien e inserten los valores en la base de datos.
     */
    @Test
    fun `when the api return something then get values from api`() = runBlocking {
        // given
        val myList = listOf(Quote("La perseverancia vence a la falacia", "dwr"))
        coEvery { quoteRepository.getAllQuotesFromApi() } returns myList
        // when

        val response = getQuotesUseCase()
        // then
        coVerify(exactly = 1) { quoteRepository.clearQuotes() }
        coVerify(exactly = 1) { quoteRepository.insertQuotes(any()) }
        coVerify(exactly = 0) { quoteRepository.getAllQuotesFromDatabase() }
        assert(myList == response)
    }
}