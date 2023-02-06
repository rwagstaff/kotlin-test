import kotlinx.coroutines.*

// Run with -Dkotlinx.coroutines.debug

fun main() = runBlocking {
    val jobs = arrayListOf<Job>()

    // Wrong way, suspend function should define the context
    jobs += launch(Dispatchers.Default) {
        println("'defaultDispatcher': In Thread ${Thread.currentThread().name}")
    }

    jobs += launch(Dispatchers.IO) {
        println("'IO Dispatcher': In Thread ${Thread.currentThread().name}")
    }

    jobs += launch(Dispatchers.Unconfined) {
        // Correct way, suspend function defines dispatcher. Should still print IO dispatcher
        go("Unconfined")
    }

    jobs += launch(Dispatchers.Unconfined) {
        // Correct way, suspend function defines dispatcher. Should still IO dist
        println("Unconfined: In Thread ${Thread.currentThread().name}")
    }

    jobs += launch(newSingleThreadContext("OwnThread")) {
        println("'newSTC': In Thread ${Thread.currentThread().name}")
    }



    jobs.forEach{ it.join()}




}

/**
 * This is the correct way to dispatch a coroutine,
 */
suspend fun go(name: String) {
    withContext(Dispatchers.IO) {
        println("$name: In Thread ${Thread.currentThread().name}")
    }
}

