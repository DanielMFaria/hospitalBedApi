package com.hospitalbedapi.service

import com.hospitalbedapi.dto.LeitoDTO
import com.hospitalbedapi.model.Leito
import com.hospitalbedapi.repository.LeitoRepository
import org.springframework.stereotype.Service

@Service
class LeitoService(private val repository: LeitoRepository) {

    fun listarTodos(): List<Leito> {
        return repository.findAll()
    }

    fun criarLeito(dto: LeitoDTO): Leito {
        // Regra de Negócio: Se estiver em manutenção, não pode ter paciente
        if (dto.status == Leito.StatusLeito.MANUTENCAO && !dto.pacienteAtual.isNullOrBlank()) {
            throw IllegalArgumentException("Leito em manutenção não pode receber pacientes!")
        }

        val leito = Leito(
            codigo = dto.codigo,
            status = dto.status,
            pacienteAtual = dto.pacienteAtual
        )

        return repository.save(leito)
    }
}