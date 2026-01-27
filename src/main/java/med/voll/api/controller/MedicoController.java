package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    //public void cadastrar(@RequestBody String json) {
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
//        System.out.println(dados);
//        System.out.println("\n-------");
//        System.out.println("Nome: " + dados.nome());
//        System.out.println("CRM: " + dados.crm());
//        System.out.println("E-MAIL: " + dados.email());
//        System.out.println("ESPECIALIDADE: " + dados.especialidade());
//        System.out.println("LOGRADOURO: " + dados.endereco().logradouro());
//        System.out.println("BAIRRO: " + dados.endereco().bairro());
//        System.out.println("CEP: " + dados.endereco().cep());
//        System.out.println("CIDADE: " + dados.endereco().cidade());
//        System.out.println("COMPLEMENTO: " + dados.endereco().complemento());
//        System.out.println("NUMERO: " + dados.endereco().numero());

        repository.save(new Medico(dados));
    }

//    @GetMapping
//    //public List<DadosListagemMedico> listar() {
//        return repository.findAll(paginacao).stream().map(DadosListagemMedico::new).toList();
//    }
    //comando a ser introduzido no Insomina ou postman
    //http://localhost:8080/medicos?size=1
    //http://localhost:8080/medicos?size=1&page=4
    //http://localhost:8080/medicos?sort=especialidade,crm,desc
    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        //return repository.findAll(paginacao).map(DadosListagemMedico::new);
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
        //return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    //*******Para lista todos os campos que estão na classe model ou no banco que tem a entity.*****
    @GetMapping("todos")
    public List<Medico> listar2() {
        return repository.findAll();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualisarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        //repository.deleteById(id);
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
