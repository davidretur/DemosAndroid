package com.dwr.demosmvvm.Core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * RetrofitHelper es una clase de utilidad que proporciona métodos estáticos para crear y obtener instancias de Retrofit.
 *
 * Esta clase se utiliza para configurar y construir objetos Retrofit que se utilizan para hacer solicitudes de red en toda la aplicación.
 *
 * @author [David Duarte]
 * @version 1.0
 */
object RetrofitHelper {
    /**
     * Obtiene una instancia única de Retrofit configurada con el base URL especificado y un conversor factory Gson.
     *
     * @return Una instancia de Retrofit configurada.
     */
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}