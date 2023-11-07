package pessoas.com.apipessoa.domain;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {


    @Autowired
    private pessoas.com.apipessoa.domain.PessoaRepository repository;

    public void salva(pessoas.com.apipessoa.domain.Pessoa dados) {
        repository.save(dados);
    }

    public List<pessoas.com.apipessoa.domain.Pessoa> lista() {
        var lista = repository.findAll();
        return lista;
    }

    public pessoas.com.apipessoa.domain.Pessoa atualiza( DadosAtualizaPessoa dados,Long id) {
        var pessoa = repository.getReferenceById(id);
        pessoa.atualizarInformacoes(dados);
        return pessoa;
    }

    public void deleta(Long id) {
        repository.deleteById(id);
    }

    public Pessoa detalha(Long id) {
        var pessoa = repository.getReferenceById(id);
        return pessoa;
    }
}
