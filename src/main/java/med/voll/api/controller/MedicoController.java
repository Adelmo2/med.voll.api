package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    //public void cadastrar(@RequestBody String json) {
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        System.out.println(dados);
        System.out.println("\n-------");
        System.out.println("Nome: " + dados.nome());
        System.out.println("CRM: " + dados.crm());
        System.out.println("E-MAIL: " + dados.email());
        System.out.println("ESPECIALIDADE: " + dados.especialidade());
        System.out.println("LOGRADOURO: " + dados.endereco().logradouro());
        System.out.println("BAIRRO: " + dados.endereco().bairro());
        System.out.println("CEP: " + dados.endereco().cep());
        System.out.println("CIDADE: " + dados.endereco().cidade());
        System.out.println("COMPLEMENTO: " + dados.endereco().complemento());
        System.out.println("NUMERO: " + dados.endereco().numero());

        repository.save(new Medico(dados));

    }
}
