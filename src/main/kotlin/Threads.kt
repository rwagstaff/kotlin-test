import kotlinx.coroutines.joinAll
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

const val loops: Int = 500;
const val num_tasks: Int = 10_00
const val wait_ms = 10L

fun main() {
    println("Starting")

    val result = AtomicInteger()
    val threads = mutableListOf<Thread>()

    for (i in 1..num_tasks) {
        threads.add(thread {
            for (x in 1..loops) {
                Thread.sleep(wait_ms)
            }

            result.getAndIncrement()
        })
    }

    /**
     * The calling thread blocks until the thread has finished
     */
    threads.forEach { it.join() }
    println(result.get())
}