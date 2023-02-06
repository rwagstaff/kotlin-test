import kotlinx.coroutines.*

/**
 * join will wait for the corountine
 * cancel - will cancel
 * withTimeout - coroutine will need to finish in a certain time
 */
fun main() = runBlocking {
    val job = launch {
        repeat(100) {
            delay(10)
            print(".")
        }
    }

    delay(250)
    job.cancelAndJoin()

    println("Done")
}