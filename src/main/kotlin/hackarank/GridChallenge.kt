package hackarank

val grid = arrayOf(
    "abc",
    "ade",
    "efg",
)

val grid2 = arrayOf(
    "abcz",
    "adea",
    "efgb",
    "abcd",
)

val grid3 = arrayOf(
    "acda",
    "adez",
    "efgb",
)

fun main() {
    println(isColOrderCorrect(grid))
    println(isColOrderCorrect(grid2))
    println(isColOrderCorrect(grid3))
}

fun isColOrderCorrect(arr: Array<String>): String {
    val sorted = arr.map {
        it.toCharArray().map { c -> c.toString() }.sorted()
    }

    val cols = mutableListOf<List<String>>()
    for (i in sorted.indices) {
        val colList = mutableListOf<String>()
        for (n in sorted.indices) {
            colList.add(sorted[n][i])
        }

        cols.add(colList)
    }

    println(cols)

    return if (cols.all { it == it.sorted() }) "YES" else "NO"
}