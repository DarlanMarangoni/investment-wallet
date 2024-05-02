package com.darlanmarangoni.cashcontrol.commons

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(value = [ObjectNotFoundException::class])
    fun objectNotFoundException(ex: ObjectNotFoundException): ResponseEntity<StandardError> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(
                StandardError(
                status = HttpStatus.NOT_FOUND.value(),
                message = ex.message ?: ""
            )
            )
    }
}