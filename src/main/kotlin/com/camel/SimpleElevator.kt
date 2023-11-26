package com.camel

import kotlin.math.abs

/**
 * A simple elevator that will go to each floor in the order they were provided.
 * @param timeBetweenFloors the time it takes to move between a single floor
 */
class SimpleElevator(private val timeBetweenFloors: Int) : Elevator<Int> {

    /**
     * @see Elevator
     */
    override fun run(startFloor: Int, floorsToVisit: List<Int>): Pair<Int, List<Int>> {
        var totalTime = 0
        var from = startFloor
        val floors = mutableListOf(startFloor)
        floorsToVisit.forEach { f ->
            totalTime += abs(f - from) * timeBetweenFloors
            from = f
            floors.add(f)
        }
        return Pair(totalTime, floors)
    }
}
