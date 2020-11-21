package com.gamecodeschool.basicclasses

import Carrier
import android.util.Log

class ShipYard {

    // shipを使用する
    fun serviceShip(shipToBeServiced: Ship){
        shipToBeServiced.serviceShip()
        Log.i("Servicing","${shipToBeServiced.name}")
    }
}