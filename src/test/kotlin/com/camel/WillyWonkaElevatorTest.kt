package com.camel

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WillyWonkaElevatorTest {

    private val elevator: Elevator<Pair<Int, Int>> = WillyWonkaElevator(SimpleElevatorTest.TIME_BETWEEN_FLOORS)

    @Test
    fun runTest1() {
        val out = elevator.run(Pair(1, 2), listOf(Pair(2, 9), Pair(1, 32), Pair(3, 22)))
        assertEquals(Pair(303, listOf(Pair(1, 2), Pair(2, 9), Pair(3, 22), Pair(1, 32))), out)
    }
}
