package med.voll.api.domain.consulta.validacoes.cancelamento;

import med.voll.api.medico.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {
    void validar(DadosCancelamentoConsulta dados);
}
