package com.devcom.ferretaxf.Colecciones

import com.google.firebase.Timestamp
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.ServerTimestamp

class direccion (@get:Exclude var id: String = "",
                 var idcliente: String = "",
                 var nombre: String = "",
                 var apellido: String = "",
                 var calle: String = "",
                 var colonia: String = "",
                 var nexterior: String = "",
                 var telefono: String = "",
                 ){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Order

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}