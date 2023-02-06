// Interface
interface WalK {
    fun walk(): Unit
}

// EVERYTHING IN KOTLIN IS PUBLIC BY DEFAULT
// CLASSES ARE FINAL BY DEFAULT
// property declaration in constructor
open class Person(var name: String) : WalK {

    // Runs after constructor, typically used for more complex initialisation
    init {
        this.name = name.trim()
        println("Init")
    }

    // Static methods
    companion object {
        fun createPeople(vararg names: String): List<Person> {
            return names.map { Person(it) }
        }

        fun methodExpression() = println("Helllo")
    }

    override fun walk() {
        TODO("Not yet implemented")
    }
}

// Open Class
class Student(name: String, var course: String?) : Person(name) {
    // Init called immediately after the primary constructor, used for more complicated initialisation
    init {

        println("init2")
    }
}

// Functions are first class citizens in Kotlin, ie are can pass them around
// In java, objects are first class citizens
fun findMin(names: List<Person>): String {
    val n = names.map { it.name }
    return n.reduce { a: String, b: String ->
        a.coerceAtMost(b)
    }
}

// Main
class Program {
    companion object {
        // Mark this method as static in the JVM
        @JvmStatic
        fun main(args: Array<String>) {
            println("Hello World")
            // Instance of Class - no new keyword
            val person = Person("Jeff")
            val student = Student("Steve", "History")

            // Elvis operator for null safety
            val trimmed = student.course?.trim()

            // Uses == for string comparison
            if (person.name == "Jeff") {
                println("Found ${person.name}")
            }

            val people = Person.createPeople("George", "Fred", "Andy")
            // Default function parameter name 'it' and :: colon syntax for single parameter functions
            people.map { it.name }.forEach(::println)
            println(findMin(people))
            // When the function is the last parameter it can be passed in though the curly braces
            execUser { id, name ->
                println("User $name has id $id")
            }
        }

        private fun execUser(fn: (String, String) -> Unit) {
            val user = User(1, "another name")
            println(user)
            // Destructuring
            val (id, name) = user
            fn(id.toString(), name)
        }

    }
}

// Data class
// Most people recommend not to use inheritance with data classes
// https://stackoverflow.com/questions/26444145/extend-data-class-in-kotlin
data class User(val id: Int, val name: String)

// How does kotlin help with functional programming
// Immutability val, immutable collections
// Higher order functions
// Examples map, flatMap - Passing functions into functions

// What is higher order functions?
// It is a function that can be passed to order returned from another function


// What is let apply?

// By Inject?
