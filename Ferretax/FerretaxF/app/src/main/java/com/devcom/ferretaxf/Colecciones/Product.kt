package com.devcom.ferretaxf.Colecciones

import com.google.firebase.firestore.Exclude

data class Product(@get:Exclude var id: String? = null,
                   var nombre:String? = null,
                   var descripcion: String? = null,
                   var imgUrl: String? = null,
                   var cantidad: Int = 0,
                   @get:Exclude var newQuantity: Int = 1,
                   var precio: Double = 0.0,
                   var VendedorId: String = ""){

    fun totalPrice(): Double = newQuantity * precio

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}
