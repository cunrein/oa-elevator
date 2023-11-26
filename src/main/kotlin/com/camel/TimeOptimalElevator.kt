package com.camel

import kotlin.math.abs

/**
 * This is a time optimal'ish elevator. It uses a greedy algorithm to move to the closest floor. the greedy method used
 * is just one step, so it will be at worst case two (2) time the optimal travel time that could be improved by
 * investigating more steps.
 */
class TimeOptimalElevator(private val timeBetweenFloors: Int) : Elevator<Int> {

    /**
     * This could probably use some work to make it better.
     * @see Elevator
     */
    override fun run(startFloor: Int, floorsToVisit: List<Int>): Pair<Int, List<Int>> {
        var totalTime = 0
        var from = startFloor
        val floors = mutableListOf(startFloor)
        val ftv = floorsToVisit.toMutableList()

        while (ftv.size > 0) {
            var closestDist = Int.MAX_VALUE
            var closestFloor = Int.MIN_VALUE
            var closestIndex = -1
            ftv.forEachIndexed { i, f ->
                val dist = abs(f - from)
                if (closestDist > dist) {
                    closestDist = dist
                    closestFloor = f
                    closestIndex = i
                }
            }
            if (closestIndex != -1) {
                ftv.removeAt(closestIndex)
                totalTime += closestDist * timeBetweenFloors
                from = closestFloor
                floors.add(closestFloor)
            } else {
                throw IllegalStateException("Invalid data provided.")
            }

        }
        return Pair(totalTime, floors.toList())
    }
}
