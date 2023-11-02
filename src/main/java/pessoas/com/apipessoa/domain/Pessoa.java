package pessoas.com.apipessoa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Entity(name = "Pessoa")
@Table(name = "pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;



    public Pessoa(DadosCadastroPessoa dados) {
        this.nome = dados.nome();
        this.dataNascimento = dados.dataNascimento();
    }

    public void atualizarInformacoes(DadosAtualizaPessoa dados) {
        if ( dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.dataNascimento() != null){
            this.dataNascimento = dados.dataNascimento();
        }

    }

}
