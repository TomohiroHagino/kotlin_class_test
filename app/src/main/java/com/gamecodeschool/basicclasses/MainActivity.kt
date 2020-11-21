package com.gamecodeschool.basicclasses

import Carrier
import Destroyer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val friendlyDestroyer = Destroyer("Invincible")
        val friendlyCarrier = Carrier("Indomitable")

        val enemyDestroyer = Destroyer("Grey Death")
        val enemyCarrier = Carrier("Big Grey Death")

        val friendlyShipyard = ShipYard()

        // 小さな戦い
        friendlyDestroyer.takeDamage(enemyDestroyer.attack())
        friendlyDestroyer.takeDamage(enemyCarrier.attack())
        enemyCarrier.takeDamage(friendlyCarrier.attack())
        enemyCarrier.takeDamage(friendlyDestroyer.attack())

        // 供給状況の確認
        friendlyDestroyer.showStats()
        friendlyCarrier.showStats()

        // 造船所に停泊する
        friendlyShipyard.serviceShip(friendlyCarrier)
        friendlyShipyard.serviceShip(friendlyDestroyer)

        // 供給状況を確認する
        friendlyDestroyer.showStats()
        friendlyCarrier.showStats()

        // 敵を倒す
        enemyDestroyer.takeDamage(friendlyDestroyer.attack())
        enemyDestroyer.takeDamage(friendlyCarrier.attack())
        enemyDestroyer.takeDamage(friendlyDestroyer.attack())
    }
}