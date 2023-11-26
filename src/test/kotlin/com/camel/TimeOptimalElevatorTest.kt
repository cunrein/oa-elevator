package com.camel

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TimeOptimalElevatorTest {

    private val elevator: Elevator<Int> = TimeOptimalElevator(SimpleElevatorTest.TIME_BETWEEN_FLOORS)

    @Test
    fun runTest1() {
        val out = elevator.run(12, listOf(2, 9, 1, 32))
        assertEquals(Pair(420, listOf(12, 9, 2, 1, 32)), out)
    }

    @Test
    fun runTest2() {
        val out = elevator.run(22, listOf(2, 9, 1, 32, -1))
        assertEquals(Pair(430, listOf(22, 32, 9, 2, 1, -1)), out)
    }
}
