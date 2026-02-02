package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
        repository.save(new Paciente(dados));
//        System.out.println(dadosCadastroPaciente);
//        System.out.println("\n");
//        System.out.println("Telefone: " + dadosCadastroPaciente.telefone() + " Cidade: " + dadosCadastroPaciente.endereco().cidade());
    }

//    @GetMapping("args")
//    public Page<DadosListagemPaciente> listar2(@PageableDefault(page = 0, size = 10, sort = {"nome"}) Pageable paginacao) {
//        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
//    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listar2(@PageableDefault(page = 0, size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("todos")
    public Page<DadosListagemPaciente> listar3(@PageableDefault(page = 0, size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = repository.getReferenceById((dados.id()));
        paciente.atualisarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        //repository.deleteById(id);
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
    }
}
