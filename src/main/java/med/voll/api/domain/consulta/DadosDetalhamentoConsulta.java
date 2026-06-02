package med.voll.api.domain.consulta;

import med.voll.api.domain.medico.Especialidade;
import med.voll.api.medico.MotivoCancelamento;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
}
