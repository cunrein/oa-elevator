package com.camel

import kotlin.test.Test
import kotlin.test.assertEquals

class SimpleElevatorTest {

    private val elevator: Elevator<Int> = SimpleElevator(TIME_BETWEEN_FLOORS)

    @Test
    fun runTest1() {
        val out = elevator.run(12, listOf(2, 9, 1, 32))
        assertEquals(Pair(560, listOf(12, 2, 9, 1, 32)), out)
    }

    @Test
    fun runTest2() {
        val out = elevator.run(1, listOf(2, 9, 1, 32))
        assertEquals(Pair(470, listOf(1, 2, 9, 1, 32)), out)
    }

    companion object {
        const val TIME_BETWEEN_FLOORS = 10
    }
}
