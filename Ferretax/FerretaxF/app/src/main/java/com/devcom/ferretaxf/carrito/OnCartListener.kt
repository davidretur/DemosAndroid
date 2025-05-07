package com.devcom.ferretaxf.carrito

import com.devcom.ferretaxf.Colecciones.Product


interface OnCartListener {
    fun setQuantity(product: Product)
    fun showTotal(total: Double)
}