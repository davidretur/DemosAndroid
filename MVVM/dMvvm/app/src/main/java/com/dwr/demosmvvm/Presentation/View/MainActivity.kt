package com.dwr.demosmvvm.Presentation.View

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.dwr.demosmvvm.Presentation.ViewModel.QuoteViewModel
import com.dwr.demosmvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * MainActivity es una activity principal de Android que muestra y maneja citas.
 *
 * Esta activity utiliza View Binding para vincular la interfaz de usuario con el código.
 *
 * @author [David Duarte]
 * @version 1.0
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    // binding de la vista
    private lateinit var binding: ActivityMainBinding

    // creamos el viewModel
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // binding de la vista
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializamos el ViewModel
        quoteViewModel.onCreate()
        
        // Obsevamos los cambios en el modelo de cita y actualizamos la interfaz de usuario
        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })
        
        // Obsevamos el estado de carga y mostramos o ocultamos el indicador de progreso
        quoteViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })

        // Manejamos el clic en la vista principal para obtener una cita aleatoria
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }
}