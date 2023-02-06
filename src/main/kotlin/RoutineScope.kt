import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

    // Best practices
    // Never use Global scope
    // Never block the thread
    // Never return from a suspend functions without the co routines finishing
fun main(): Unit = runBlocking {

    launch {
        runWithLocalScope()
        print("Run with local scope returns")
    }
}

suspend fun runWithLocalScope() {
    coroutineScope {
    // Wrapping these two coroutines in the coroutines scope ensure that both finish when the function returns
        launch {
            println("Launch 1")
            delay(1000)
        }
        launch {
            println("Launch 2")
            delay(2000)
        }

    }
    println("runWithLocalScope finished")
}