package hackarank

fun main() {
    val arr = intArrayOf(4, 5, 7, 10, 9, 1, 2, 3)
    val min = nth(arr, 4, IntArray::sortedArray)
    println("$min ${min.sum()}")
    val max = nth(arr, 4, IntArray::sortedArrayDescending)
    println("$max ${max.sum()}")
}

fun nth(arr: IntArray, n: Int, sortedFn: (IntArray) -> IntArray): List<Int> {
    val sorted = sortedFn.invoke(arr)
    return sorted.slice(0 until n)
}




