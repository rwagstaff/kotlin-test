class Car(var colour: String, val model: String) {
    fun changeColour(colour: String) {
        this.colour = colour;
    }
}

fun main() {
    // With let
    val a = Car("Red", "VW").let {
        it.changeColour("Blue")
        println(it.model)
    }

    // Without Let
    val c = Car("Yellow", "Audi")
    println(c.changeColour("Purple"))
    println(c.model)


    Car("Red", "VW").run {
        // Object reference changes to this
        this.changeColour("Blue")
        println(this.model)
    }
    // Also will return the new object
    val d = Car("Green", "Ferrari").also {
        println("")
        it.changeColour("Grey")
    }

    val e = Car("Green", "Ferrari").apply{
        // Different way of accessing properties
        colour = "Green"
        changeColour("Grey")
    }
}