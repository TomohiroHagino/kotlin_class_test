import com.gamecodeschool.basicclasses.Ship

class Destroyer(name: String): Ship(
    name,
    "Destroyer",
    10,
    200) {

    // 外部アクセスの出来ない変数
    private var shotPower = 60

    override fun attack():Int {
        // attacksRemainingの値により処理がわかれる。
        return if (attacksRemaining > 0) {
            attacksRemaining--
            shotPower
        }else{
            0
        }
    }
}