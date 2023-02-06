import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

//suspend fun main() = coroutineScope {
//    launch {
//        delay(10000)
//        // When we call delay it pauses the coroutine (not the thread), however other processes can still use the thread.
//        // If we call Thread.sleep it pauses the thread
//        println("Kotlin Coroutines World!")
//    }
//    println("Hello")
//}


/**
 * Coroutines provide an asyncronous mapping mechanism - We can think of them os being light weight threads
 * Coroutines and thread are not the same thing, there is not one to one mapping between a co-routines and a thread
 * Coroutines Context is abit like Thread Local storage
 *
 */
fun main() = runBlocking {// Run blocking is very useful for running test
    println("Starting")

    val result = AtomicInteger()
    val threads = mutableListOf<Job>()

    for (i in 1..num_tasks) {
        threads.add(launch(Dispatchers.IO) {// Dispatchers - Every Routine will be dispatched on a Thread that is not the main thread
            for (x in 1..loops) {
                // Delay can only be called from a coroutines or suspend function
                delay(wait_ms) // Delay is non-blocking - the thread is still active
            }

            result.getAndIncrement();
        })
    }



    threads.forEach { it.join() }
    println(result.get())
}


// Suspends functions can only be run from other suspend functions or within a coroutine