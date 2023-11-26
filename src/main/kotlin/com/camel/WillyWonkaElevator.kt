package com.camel

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * This is an elevator that can go anyways (up, down, left, right), so it travels from door to door not floor to floor.
 * This implementation also uses a one step greedy algorithm to decide which door to move to.
 *
 * Note the interface this inherits from uses the startFloor and floorsToVisit, I would change it to Doors but that
 * could cause problems with the JVM.
 */
class WillyWonkaElevator(private val timeBetweenDoors: Int) : Elevator<Pair<Int, Int>> {

    /**
     * The return value will not be precise, it is the closest integer to the time.
     * @see Elevator
     */
    override fun run(startFloor: Pair<Int, Int>, floorsToVisit: List<Pair<Int, Int>>): Pair<Int, List<Pair<Int, Int>>> {
        var totalTime = 0.0
        var from = startFloor
        val doors = mutableListOf(startFloor)
        val dtv = floorsToVisit.toMutableList()

        while (dtv.size > 0) {
            var closestDist = Double.MAX_VALUE
            var closestDoor = Pair(Int.MIN_VALUE, Int.MIN_VALUE)
            var closestIndex = -1
            dtv.forEachIndexed { i, f ->
                val dist = sqrt((f.first.toDouble() - from.first).pow(2) + (f.second.toDouble() - from.second).pow(2))
                if (closestDist > dist) {
                    closestDist = dist
                    closestDoor = f
                    closestIndex = i
                }
            }
            if (closestIndex != -1) {
                dtv.removeAt(closestIndex)
                totalTime += closestDist * timeBetweenDoors
                from = closestDoor
                doors.add(closestDoor)
            } else {
                throw IllegalStateException("Invalid data provided.")
            }

        }
        return Pair(totalTime.toInt(), doors.toList())
    }
}
