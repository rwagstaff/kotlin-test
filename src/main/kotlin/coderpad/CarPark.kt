package coderpad

import java.lang.RuntimeException

// To execute Kotlin code, please define a top level function named main


class CarPark(compactSpaces: Int, regularSpaces: Int, largeSpaces: Int) {

    private val spaces: List<Space>

    init {
        spaces = initSpaces(compactSpaces, Spot.COMPACT) + initSpaces(regularSpaces, Spot.REGULAR) + initSpaces(largeSpaces, Spot.LARGE)
    }

    private fun initSpaces(noOfSpaces: Int, spot: Spot): MutableList<Space> {
        val initSpaces = mutableListOf<Space>()
        for (i in 1..noOfSpaces) {
            initSpaces.add(Space(false, spot))
        }
        return initSpaces;
    }

    fun isCarParkEmpty(): Boolean {
        return spaces.none { it.full }
    }

    fun isCarParkFull(): Boolean {
        return spaces.all { it.full }
    }

    fun park(vehicle: Vehicle, spaceNumber: Int) {
        val space = spaces[spaceNumber];

        val isFree = vehicle.allowedSpaces.contains(space.spot) && !space.full

        if (isFree) {

            when (vehicle) {
                is Vehicle.Car -> space.full = true
                is Vehicle.Bike -> space.full = true
                is Vehicle.Van -> {
                    if (space.spot == Spot.REGULAR) {
                        val leftSpace = spaces[spaceNumber - 1]
                        val rightSpace = spaces[spaceNumber + 1]

                        if (!leftSpace.full && !rightSpace.full) {
                            leftSpace.full = true
                            rightSpace.full = true
                            space.full = true
                        }
                        else {
                            throw RuntimeException("Cannot park here")
                        }
                    }
                }
            }

        } else {
            throw RuntimeException("Cannot park here")
        }

    }
}

data class Space(var full: Boolean, val spot: Spot)

enum class Spot {
    COMPACT, REGULAR, LARGE
}

sealed class Vehicle(val allowedSpaces: List<Spot>) {
    class Car : Vehicle(listOf(Spot.COMPACT, Spot.REGULAR))
    class Bike : Vehicle(listOf(Spot.COMPACT, Spot.REGULAR, Spot.LARGE))
    class Van : Vehicle(listOf(Spot.REGULAR, Spot.LARGE))
}


fun main() {
    val carPark = CarPark(3, 6, 7)

    carPark.park(Vehicle.Car(), 3)

}
