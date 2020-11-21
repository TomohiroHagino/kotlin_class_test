import android.util.Log

class Carrier (name: String){
    // 船の名前を定義
    var name: String = ""
        private set

    // shipの型はなにか？
    // それはCarrier（航空母艦。空母）
    val type = "Carrier"

    // 弾薬の量
    private var hullIntegrity = 100

    // 残り攻撃回数
    var attacksRemaining = 1
        // Cannot be directly set externally
        private set

    private var attackPower = 120

    // 沈んでいるかどうか
    private var sunk = false

    // このコードはインスタンスが初期化されるときに実行される。
    init {
        // なので、nameパラメータを使用できる
        this.name = "$type $name"
    }


    fun takeDamage(damageTaken: Int) {
        if (!sunk) {
            hullIntegrity -= damageTaken
            Log.d("$name damage taken =","$damageTaken")
            Log.d("$name hull integrity =","$hullIntegrity")

            if (hullIntegrity <= 0) {
                Log.d("Carrier", "$name has been sunk")
                sunk = true
            }
        } else {
            // Already sunk
            Log.d("Error", "Ship does not exist")
        }
    }

    // 空中攻撃
    fun launchAerialAttack() :Int {
        // 攻撃回数がいくつあるかによってどちらかがコールされる
        return if (attacksRemaining > 0) {
            attacksRemaining--
            attackPower
        }else{
            0
        }
    }

    fun serviceShip() {
        attacksRemaining = 20
        hullIntegrity = 200
    }
}