package com.dwr.demosmvvm.Core.Di

import com.dwr.demosmvvm.Data.Network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * NetworkModule es un módulo de dependencia que proporciona configuraciones necesarias para la red.
 *
 * Este módulo contiene proveedores de objetos Retrofit y QuoteApiClient que se utilizan en toda la aplicación.
 *
 * @author [David Duarte]
 * @version 1.0
 */
@Module
// Se determina el alcance de las dependencias que se proveen
@InstallIn(SingletonComponent::class)
object NetworkModule {
    /**
     * Provee una instancia única de Retrofit para todas las solicitudes de red.
     *
     * @return Una instancia de Retrofit configurada con el base URL y el conversor factory.
     */
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * Provee una instancia única de QuoteApiClient utilizando Retrofit.
     *
     * @param retrofit La instancia de Retrofit configurada previamente.
     * @return Una instancia de QuoteApiClient creada a partir de Retrofit.
     */
    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit): QuoteApiClient {
        return retrofit.create(QuoteApiClient::class.java)
    }
}