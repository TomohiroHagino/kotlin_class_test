import com.gamecodeschool.basicclasses.Ship

class Carrier (name: String): Ship(
    name,
    "Carrier",
    20,
    100){

    // 外部アクセスの出来ない変数
    private var attackPower = 120

    override fun attack(): Int {
        // attacksRemainingの値により処理がわかれる。
        return if (attacksRemaining > 0) {
            attacksRemaining--
            attackPower
        }else{
            0
        }
    }
}