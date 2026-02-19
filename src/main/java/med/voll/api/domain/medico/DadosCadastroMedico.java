package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank
        String nome,

        @NotBlank(message = "{email.obrigatorio}")
        @Email(message = "{email.invalido}")
        String email,

        @NotBlank(message = "Telefone é obrigatório")
        String telefone,

        @NotBlank(message = "{crm.obrigatorio}")
        @Pattern(regexp = "\\d{4,6}", message = "{crm.invalido}")
        //@JsonIgnore
        String crm,

        @NotNull(message = "Especialidade é obrigatório")
        Especialidade especialidade,

        @NotNull(message = "Dados do endereço são obrigatórios")
        @Valid
        DadosEndereco endereco) {
}
