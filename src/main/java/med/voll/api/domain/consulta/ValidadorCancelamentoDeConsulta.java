package med.voll.api.domain.consulta;

import med.voll.api.medico.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {
    void validar(DadosCancelamentoConsulta dados);
}
