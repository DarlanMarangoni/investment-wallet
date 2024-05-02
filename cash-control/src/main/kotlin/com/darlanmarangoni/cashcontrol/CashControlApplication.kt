package com.darlanmarangoni.cashcontrol

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CashControlApplication

fun main(args: Array<String>) {
	runApplication<CashControlApplication>(*args)
}
