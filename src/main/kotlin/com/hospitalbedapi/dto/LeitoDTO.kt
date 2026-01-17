package com.hospitalbedapi.dto

import com.hospitalbedapi.model.Leito
import jakarta.validation.constraints.NotBlank

data class LeitoDTO(
    @field:NotBlank(message = "O código do leito é obrigatório")
    val codigo: String,

    val status: Leito.StatusLeito,

    val pacienteAtual: String? = null
)