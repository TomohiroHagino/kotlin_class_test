package com.gamecodeschool.basicclasses

import android.util.Log

abstract class Ship(
    val name: String,
    private var type: String,
    private val maxAttacks: Int,
    private val maxHullIntegrity: Int) {

    // 全てのshipが持っているstats(統計)
    private var sunk = false
    private var hullIntegrity: Int
    protected var attacksRemaining: Int

    init{
        hullIntegrity = this.maxHullIntegrity
        attacksRemaining = 1
    }

    // これら３つの関数はどこでも使える
    fun takeDamage(damageTaken: Int) {
        if (!sunk) {
            hullIntegrity -= damageTaken
            Log.i("$name damage taken =","$damageTaken")
            Log.i("$name hull integrity =","$hullIntegrity")

            if (hullIntegrity <= 0) {
                Log.i(type, "$name has been sunk")
                sunk = true
            }
        } else {
            // Already sunk
            Log.i("Error", "Ship does not exist")
        }
    }

    fun serviceShip() {
        attacksRemaining = maxAttacks
        hullIntegrity = maxHullIntegrity
    }

    fun showStats(){
        Log.i("$type $name",
            "Attacks:$attacksRemaining - Hull:$hullIntegrity")
    }

    abstract fun attack(): Int

}