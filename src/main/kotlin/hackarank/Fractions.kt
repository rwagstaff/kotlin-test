package hackarank

fun numberRange(x: IntArray) {
    var pos = 0
    var neg = 0
    var zero = 0

    x.forEach {
        when {
            it < 0 -> neg++
            it > 0 -> pos++
            it == 0 -> zero++
        }

    }

    val size = x.size.toDouble()
    print("Neg ${neg.toDouble() / size}, Pos ${pos.toDouble() / size}, Zero ${zero.toDouble() / size}")
}

fun main() {
    numberRange(intArrayOf(1, -1, 0, 1, 2, 2, 0))
}