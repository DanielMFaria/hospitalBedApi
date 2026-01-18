package com.hospitalbedapi.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(ex: IllegalArgumentException): ResponseEntity<Map<String, String>> {
        val errorResponse = mapOf(
            "erro" to "Regra de Negócio Violada",
            "mensagem" to (ex.message ?: "Erro desconhecido")
        )
        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }

    ExceptionHandler(org.springframework.dao.DataIntegrityViolationException::class)
    fun handleConflict(ex: Exception): ResponseEntity<Map<String, String>> {
        val errorResponse = mapOf(
            "erro" to "Conflito de Dados",
            "mensagem" to "Já existe um leito cadastrado com este código."
        )
        return ResponseEntity(errorResponse, HttpStatus.CONFLICT)
    }
}