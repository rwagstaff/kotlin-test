package hackarank


fun main() {

    val arr = intArrayOf(1, 2, 1, 2, 1, 3, 1)
    val matches = mutableMapOf<Int, Int>()

    arr.forEach {
        if (!matches.containsKey(it)) {
            val size = arr.filter { n -> n == it }.size
            val pairs = size / 2
            matches[it] = pairs
        }
    }

    println("Pairs $matches")


}