package com.gamecodeschool.basicclasses

import android.util.Log

class Destroyer(name: String) {
    // 船の名前を定義
    var name: String = ""
        private set

    // shipの型はなにか？
    // それはDestroyer（駆逐艦）
    val type = "Destroyer"

    // shipが搭載できる弾薬（hullIntegrity）の量
    private var hullIntegrity = 200

    // 兵器庫にのっているショットの数
    var ammo = 1
        // 外部から直接設定できないように
        private set

    // 外部からアクセス出来ない変数
    private var shotPower = 60

    // shipは沈んだかどうか
    private var sunk = false

    // このコードはインスタンスが初期化されるときに実行される。
    init {
        // なので、nameパラメータを使用できる
        this.name = "$type $name"
    }

    fun takeDamage(damageTaken: Int) {
        if (!sunk) {
            hullIntegrity -= damageTaken
            Log.i("$name damage taken =","$damageTaken")
            Log.i("$name hull integrity =","$hullIntegrity")

            if (hullIntegrity <= 0) {
                Log.d("Destroyer", "$name has been sunk")
                sunk = true
            }
        } else {
            // Already sunk
            Log.d("Error", "Ship does not exist")
        }
    }

    fun shootShell():Int {
        // 弾薬がいくつあるかによってどちらかがコールされる
        return if (ammo > 0) {
            ammo--
            shotPower
        }else{
            0
        }
    }

    fun serviceShip() {
        ammo = 10
        hullIntegrity = 100
    }
}