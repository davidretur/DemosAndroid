package com.dwr.demosmvvm.Core.Di

import android.content.Context
import androidx.room.Room
import com.dwr.demosmvvm.Data.database.QuoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * RoomModule es un módulo de dependencia que proporciona configuraciones necesarias para la base de datos Room.
 *
 * Este módulo contiene proveedores de objetos QuoteDatabase y QuoteDao que se utilizan en toda la aplicación.
 *
 * @author [David Duarte]
 * @version 1.0
 */
@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val QUOTE_DATABASE_NAME = "quote_database"

    /**
     * Provee una instancia única de QuoteDatabase utilizando Room.
     *
     * @param context El contexto de la aplicación.
     * @return Una instancia de QuoteDatabase configurada con el nombre de la base de datos y los constructores necesarios.
     */
    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, QuoteDatabase::class.java, QUOTE_DATABASE_NAME).build()

    /**
     * Provee una instancia única de QuoteDao utilizando la base de datos proporcionada.
     *
     * @param db La instancia de QuoteDatabase configurada previamente.
     * @return Una instancia de QuoteDao creada a partir de QuoteDatabase.
     */
    @Singleton
    @Provides
    fun provideQuoteDao(db: QuoteDatabase) = db.getQuoteDao()
}