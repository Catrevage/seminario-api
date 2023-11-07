package pessoas.com.apipessoa.domain;


import java.time.LocalDate;

public record DadosDetalharPessoa(Long id, String nome, LocalDate dataNascimento) {
    public DadosDetalharPessoa(pessoas.com.apipessoa.domain.Pessoa pessoa){
        this(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getDataNascimento()
        );
    }
}

