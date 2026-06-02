package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.Especialidade;
import med.voll.api.medico.MotivoCancelamento;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
    Long idMedico,

    @NotNull
    Long idPaciente,

    @NotNull
    @Future
    LocalDateTime data,

    MotivoCancelamento motivoCancelamento,

    Especialidade especialidade) {
}


