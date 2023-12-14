package com.camel

import org.junit.jupiter.api.Assertions
import kotlin.test.Test
import kotlin.test.assertEquals

class ElevatorTwoTest {


    @Test
    fun runTest() {
        val elevator = ElevatorTwo(10, simpleRun)
        val out = elevator.run(12, listOf(2, 9, 1, 32))
        assertEquals(Pair(560, listOf(12, 2, 9, 1, 32)), out)

        val elevator2 = ElevatorTwo(10, timeOptimalRun)
        val out2 = elevator2.run(12, listOf(2, 9, 1, 32))
        assertEquals(Pair(420, listOf(12, 9, 2, 1, 32)), out2)

        val elevator3 = ElevatorTwo(10, wonkaRun)
        val out3 = elevator3.run(Pair(1, 2), listOf(Pair(2, 9), Pair(1, 32), Pair(3, 22)))
        Assertions.assertEquals(Pair(303, listOf(Pair(1, 2), Pair(2, 9), Pair(3, 22), Pair(1, 32))), out3)
    }
}