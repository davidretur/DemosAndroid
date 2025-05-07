package com.dwr.demosmvvm.Presentation.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dwr.demosmvvm.Data.Model.QuoteModel
import com.dwr.demosmvvm.Domain.GetQuotesUseCase
import com.dwr.demosmvvm.Domain.GetRandomQuoteUseCase
import com.dwr.demosmvvm.Domain.Model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * QuoteViewModel es un ViewModel de Hilt que gestiona el estado y las operaciones relacionadas con las citas.
 *
 * Este ViewModel utiliza inyección de dependencias para obtener instancias de los casos de uso de obtención de citas.
 *
 * @author David Duarte
 * @since 1.0.0
 * @param getQuotesUseCase Caso de uso para obtener citas.
 * @param getRandomQuoteUseCase Caso de uso para obtener una cita aleatoria.
 * @constructor Crea una instancia de QuoteViewModel con las dependencias necesarias.
 * @property quoteModel LiveData que contiene el modelo de cita actual.
 * @property isLoading LiveData que indica si se está realizando alguna operación de carga.
 * @property onCreate Método llamado cuando se crea el ViewModel. Obtiene una lista de citas y establece la primera cita como el modelo actual.
 * @property randomQuote Método que obtiene una cita aleatoria y la establece como el modelo actual.
 */
@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase,
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase
) : ViewModel() {
    // LiveData que almacena el modelo de cita actual
    val quoteModel = MutableLiveData<Quote>()

    // LiveData que indica si se está realizando alguna operación de carga
    var isLoading = MutableLiveData<Boolean>()

    /**
     * Método llamado cuando se crea el ViewModel. Obtiene una lista de citas y establece la primera cita como el modelo actual.
     * @see GetQuotesUseCase
     * @see Quote
     * @see MutableLiveData
     */
    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()
            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    /**
     * Método que obtiene una cita aleatoria y la establece como el modelo actual.
     * @return La cita aleatoria obtenida.
     * @throws Exception Si ocurre un error al obtener la cita aleatoria.
     * @see GetRandomQuoteUseCase
     * @see Quote
     *
     */
    fun randomQuote() {
        viewModelScope.launch {
            // Creamos un caso de uso que devuelva una lista de citas
            isLoading.postValue(true)
            val quote = getRandomQuoteUseCase()
            if (quote != null) {
                quoteModel.postValue(quote)
            }
            isLoading.postValue(false)
        }
    }
}