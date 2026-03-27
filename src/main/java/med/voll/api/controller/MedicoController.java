package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.medico.DadosListagemMedico;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(dados);
        repository.save(medico);

<<<<<<< HEAD
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
=======
        var uri = uriBuilder.path("/medidcos/{id}").buildAndExpand(medico.getId()).toUri();
>>>>>>> a66742e23c23ce6143200eed4817e14481d87e53

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

<<<<<<< HEAD
=======
    //    @GetMapping
//    //public List<DadosListagemMedico> listar() {
//        return repository.findAll(paginacao).stream().map(DadosListagemMedico::new).toList();
//    }
    //comando a ser introduzido no Insomina ou postman
    //http://localhost:8080/medicos?size=1
    //http://localhost:8080/medicos?size=1&page=4
    //http://localhost:8080/medicos?sort=especialidade,crm,desc
>>>>>>> a66742e23c23ce6143200eed4817e14481d87e53
    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }


}
