package com.devcom.ferretaxf.Producto

import com.devcom.ferretaxf.Colecciones.Product
import com.google.firebase.auth.FirebaseUser

interface MainAux {
    fun getProductsCart(): MutableList<Product>
    fun updateTotal()
    fun clearCart()

    fun getProductSelected(): Product?
    fun showButton(isVisible: Boolean)
    fun addProductToCart(product: Product)

    fun updateTitle(user: FirebaseUser)
}