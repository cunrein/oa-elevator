package com.camel

import java.util.*

fun main(args: Array<String>) {
    val timeBetweenFloors = 10
    val usage = """
            Invalid usage please use: 
            oa-elevator [optional: o] startfloor=10 floors=1,2,3,4,5
            oa-elevator w startfloor=1,2 floors=(1,2),(3,4),(5,6)
        """.trimIndent()
    if(args.size < 2 || args.size > 3) {
        println(usage)
        return
    }

    var elevatorChoice = 1
    var start = "1"
    var floors = ""
    args.forEach {
        if(it.lowercase(Locale.getDefault()) == "o") {
            elevatorChoice = 2
        }
        if(it.lowercase(Locale.getDefault()) == "w") {
            elevatorChoice = 3
        }
        if(it.startsWith("startfloor=", true)) {
            start = it.split("=")[1]
        }
        if(it.startsWith("floors=", true)) {
            floors = it.split("=")[1]
        }
    }

    val split = start.split(",")
    var sw = Pair(1, 1)
    var s = 1
    if(split.size > 1) {
        sw = Pair(split[0].toInt(), split[1].toInt())
    } else {
        s = split[0].toInt()
    }

    if (elevatorChoice == 3) {
        val elevator = WillyWonkaElevator(5)
        val floorsAndDoors = floors.split("),(").map {
            it.replace("(", "").replace(")", "")
        }.map {
            val parts = it.split(",")
            Pair(parts[0].toInt(), parts[1].toInt())
        }
        println(elevator.run(sw, floorsAndDoors))
    } else {
        val elevator = if(elevatorChoice == 1) SimpleElevator(timeBetweenFloors)
                       else TimeOptimalElevator(timeBetweenFloors)
        val floorsToVisit = floors.split(",").map { it.toInt() }.toList()
        println(elevator.run(s, floorsToVisit))
    }

}