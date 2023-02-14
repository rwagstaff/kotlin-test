import java.math.BigInteger

fun main() {
    // Without tailrec, this would throw a stack overflow exception
    // tailrec will optimise the code into a loop
    val f = fib(10000000000L, 0L, 1L)
    println(f)
}

tailrec fun fib(n: Long, a: Long, b: Long): Long {
    return if (n == 0L) b else fib(n - 1, a + b, a)
}