package com.hospitalbedapi.hospitalbed.service

import com.hospitalbedapi.dto.LeitoDTO
import com.hospitalbedapi.model.Leito
import com.hospitalbedapi.repository.LeitoRepository
import com.hospitalbedapi.service.LeitoService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.mock

class LeitoServiceTest {

    private val repository: LeitoRepository = mock()
    private val service = LeitoService(repository)

    @Test
    fun `nao deve permitir paciente em leito em manutencao`() {
        // Cenário: Tentando criar um leito em manutenção com paciente
        val dto = LeitoDTO(
            codigo = "UTI-99",
            status = Leito.StatusLeito.MANUTENCAO,
            pacienteAtual = "Paciente Teste"
        )

        // Ação e Validação: Deve lançar IllegalArgumentException
        assertThrows<IllegalArgumentException> {
            service.criarLeito(dto)
        }
    }
}