import Animal.*

/**
 * Sealed classes and interfaces represent restricted class hierarchies that provide more control over inheritance.
 * All direct subclasses of a sealed class are known at compile time.
 * No other subclasses may appear outside a module within which the sealed class is defined.
 * For example, third-party clients can't extend your sealed class in their code. Thus, each instance of a sealed class has a type from a limited set that is known when this class is compiled.
 */
sealed class Animal {
    abstract val noOfLegs: Int


    class Seal(override val noOfLegs: Int) : Animal()

    class Cat(override val noOfLegs: Int) : Animal()

    class Bird(override val noOfLegs: Int) : Animal()

    companion object {
        fun doSound(animal: Animal) {
            val sound = when (animal) {
                is Bird -> "Tweet"
                is Cat -> "Meeow"
                is Seal -> "Bark"
                else -> "I dunno"
            }
            println(sound)


        }

    }

}


fun main() {
    Animal.doSound(Bird(2))
}

