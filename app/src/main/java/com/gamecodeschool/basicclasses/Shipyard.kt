package com.gamecodeschool.basicclasses

import Carrier

class ShipYard {

    // 駆逐艦を使用する
    fun serviceDestroyer(destroyer: Destroyer){
        destroyer.serviceShip()
    }

    // 空母を使用する。
    fun serviceCarrier(carrier: Carrier){
        carrier.serviceShip()
    }
}