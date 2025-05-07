package com.devcom.ferretaxf.ordenes

import com.devcom.ferretaxf.Colecciones.Order

interface OnOrderListener {
    fun onTrack(order: Order)
}