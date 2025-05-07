package com.dwr.demosmvvm.Presentation.ViewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dwr.demosmvvm.Domain.GetQuotesUseCase
import com.dwr.demosmvvm.Domain.GetRandomQuoteUseCase
import com.dwr.demosmvvm.Domain.Model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


/**
 * Clase de prueba para el ViewModel de las citas (QuoteViewModel).
 *
 * Esta clase contiene pruebas unitarias para verificar el comportamiento de QuoteViewModel,
 * incluyendo la obtención de citas y la gestión de citas aleatorias.
 */
class QuoteViewModelTest {

    /**
     * Mocks relajados para los casos de uso.
     */
    @RelaxedMockK
    private lateinit var getQuotesUseCase: GetQuotesUseCase

    /**
     * Mock relajado para el caso de uso de obtener una cita aleatoria.
     */
    @RelaxedMockK
    private lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

    private lateinit var quoteViewModel: QuoteViewModel

    /**
     * Regla de JUnit para ejecutar tareas de LiveData de forma síncrona en las pruebas.
     */
    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    /**
     * Configuración de corrutinas para las pruebas.
     */
    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        quoteViewModel = QuoteViewModel(getQuotesUseCase, getRandomQuoteUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    /**
     * Limpieza de corrutinas después de las pruebas.
     */
    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    /**
     * Prueba que al crear el ViewModel por primera vez, se obtienen todas las citas
     * y se establece el primer valor en el LiveData.
     */
    @Test
    fun `when viewmodel is created at the first time, get all quotes and set the first value`() = runTest {
        // Given
        val quoteList = listOf(Quote("La perseverancia vence a la falacia", "dwr"), Quote("spasiva", "rusdev"))
        coEvery { getQuotesUseCase() } returns quoteList
        //When
        quoteViewModel.onCreate()
        //Then
        assert(quoteViewModel.quoteModel.value == quoteList.first())
    }

    /**
     * Prueba que cuando getRandomQuoteUseCase devuelve una cita, se establece en el LiveData.
     */
    @Test
    fun `when randomQuoteUseCase return a quote set on the livedata`() = runTest {
        // Given
        val quote = Quote("Deja de pensar en Florencia", "DavidThor :)")
        coEvery { getRandomQuoteUseCase() } returns quote
        // When
        quoteViewModel.randomQuote()
        // Then
        assert(quoteViewModel.quoteModel.value == quote)
    }

    /**
     * Prueba que si getRandomQuoteUseCase devuelve null, se mantiene el último valor en el LiveData.
     */
    @Test
    fun `if randomQuoteUseCase returns null keep the last value`() = runTest {
        // Given
        val quote = Quote("Deja de pensar en Florencia", "DavidThor :)")
        quoteViewModel.quoteModel.value = quote
        coEvery { getRandomQuoteUseCase() } returns null
        //When
        quoteViewModel.randomQuote()
        // Then
        assert(quoteViewModel.quoteModel.value == quote)
    }
}
