package com.camel

/**
 * A generic interface that represents an elevator.
 */
interface Elevator<T> {

    /**
     * Run the elevator from the start position to the requested floors.
     * @param startFloor the floor the elevator starts on
     * @param floorsToVisit the floors the elevator is to visit
     * @return a Pair that represents the run time and the order the floors were visited, including the start floor
     */
    fun run(startFloor: T, floorsToVisit: List<T>): Pair<Int, List<T>>
}