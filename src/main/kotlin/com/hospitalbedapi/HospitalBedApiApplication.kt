package com.hospitalbedapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HospitalBedApiApplication

fun main(args: Array<String>) {
    runApplication<HospitalBedApiApplication>(*args)
}