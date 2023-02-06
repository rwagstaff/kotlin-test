import kotlinx.coroutines.*

// Run with -Dkotlinx.coroutines.debug

fun main() = runBlocking {
    val jobs = arrayListOf<Job>()

    jobs += launch(Dispatchers.Default) {
        println("'defaultDispatcher': In Thread ${Thread.currentThread().name}")
    }

    jobs += launch(Dispatchers.IO) {
        println("'IO Dispatcher': In Thread ${Thread.currentThread().name}")
    }

    jobs += launch(Dispatchers.Unconfined) {
        println("'Unconfined': In Thread ${Thread.currentThread().name}")
    }

    jobs += launch(newSingleThreadContext("OwnThread")) {
        println("'newSTC': In Thread ${Thread.currentThread().name}")
    }

    jobs.forEach{ it.join()}


}

