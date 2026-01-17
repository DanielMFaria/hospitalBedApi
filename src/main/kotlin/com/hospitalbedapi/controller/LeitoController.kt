package com.hospitalbedapi.controller

import com.hospitalbedapi.dto.LeitoDTO
import com.hospitalbedapi.model.Leito
import com.hospitalbedapi.service.LeitoService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/leitos")
@Tag(name = "Gestão de Leitos", description = "Endpoints para controlar ocupação hospitalar")
class LeitoController(private val service: LeitoService) {

    @GetMapping
    @Operation(summary = "Listar todos os leitos", description = "Retorna a lista completa do hospital")
    fun listar(): List<Leito> {
        return service.listarTodos()
    }

    @PostMapping
    @Operation(summary = "Criar novo leito", description = "Cadastra um leito no sistema")
    fun criar(@RequestBody @Valid dto: LeitoDTO): ResponseEntity<Leito> {
        return ResponseEntity.ok(service.criarLeito(dto))
    }
}