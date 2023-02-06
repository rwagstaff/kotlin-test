import kotlinx.coroutines.*
import kotlin.math.log

fun main() = runBlocking {

    val result : Deferred<Int> = doWorkAsync("Work 1");
    val answer = result.await()

    println("The answer is $answer")
    val deferred = async { doWork("Work 2") }

    val res = deferred.await()

    println(res)

}

fun doWorkAsync(msg: String): Deferred<Int> = GlobalScope.async {
    println("$msg = Working")
    delay(500)
    println("$msg = Work Done")

    return@async 42
}

suspend fun doWork(msg: String): Int {
    println("$msg = Working")
    delay(500)
    println("$msg = Work Done")

    return 42
}

