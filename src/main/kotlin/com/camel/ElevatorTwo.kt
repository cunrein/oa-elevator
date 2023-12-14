package com.camel

import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

typealias ElevatorRun<T> = (Int, T, List<T>) -> Pair<Int, List<T>>
class ElevatorTwo<T>(private val timeBetween: Int, private val fn: ElevatorRun<T>) {

    fun run(start:T, goto: List<T>) : Pair<Int, List<T>> {
        return fn(timeBetween, start, goto)
    }
}

val simpleRun = {
    timeBetweenFloors: Int, startFloor: Int, floorsToVisit: List<Int> ->
        var totalTime = 0
        var from = startFloor
        val floors = mutableListOf(startFloor)
        floorsToVisit.forEach { f ->
            totalTime += abs(f - from) * timeBetweenFloors
            from = f
            floors.add(f)
        }
        Pair(totalTime, floors.toList())
}

val timeOptimalRun = {
    timeBetweenFloors: Int, startFloor: Int, floorsToVisit: List<Int> ->
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
        Pair(totalTime, floors.toList())
}

val wonkaRun = {
    timeBetweenDoors: Int, startFloor: Pair<Int, Int>, doorsToVisit: List<Pair<Int, Int>> ->
        var totalTime = 0.0
        var from = startFloor
        val doors = mutableListOf(startFloor)
        val dtv = doorsToVisit.toMutableList()

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
        Pair(totalTime.toInt(), doors.toList())
}
