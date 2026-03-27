package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.domain.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
<<<<<<< HEAD
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
=======
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriComponentsBuilder) {
        var paciente = new Paciente(dados);
        repository.save(paciente);

        var uri = uriComponentsBuilder.path("/medidcos/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));

>>>>>>> a66742e23c23ce6143200eed4817e14481d87e53
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
    }


}
