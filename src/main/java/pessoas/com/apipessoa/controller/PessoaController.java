package pessoas.com.apipessoa.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pessoas.com.apipessoa.domain.DadosAtualizaPessoa;
import pessoas.com.apipessoa.domain.DadosCadastroPessoa;
import pessoas.com.apipessoa.domain.DadosDetalharPessoa;
import pessoas.com.apipessoa.domain.Pessoa;
import pessoas.com.apipessoa.domain.PessoaService;

import java.util.List;


@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPessoa dados, UriComponentsBuilder uriBuilder) {
        var pessoa = new Pessoa(dados);
        var uri = uriBuilder.path("pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();

        service.salva(pessoa);
        return ResponseEntity.created(uri).body(new DadosDetalharPessoa(pessoa));
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listar() {
        var lista = service.lista();
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaPessoa dados) {
        var pessoa = service.atualiza(dados);
        return ResponseEntity.ok(new DadosDetalharPessoa(pessoa));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        service.deleta(id);
        return ResponseEntity.ok().build();
    }

}
