package med.voll.api.domain.paciente;

public record DadosListagemPaciente(Long id, String nome, String email, String cpf) {

    public DadosListagemPaciente(Paciente paciente) {
<<<<<<< HEAD
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
=======
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getAtivo());
>>>>>>> a66742e23c23ce6143200eed4817e14481d87e53
    }

}
