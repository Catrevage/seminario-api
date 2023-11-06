package pessoas.com.apipessoa.domain;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



import java.time.LocalDate;

public record DadosAtualizaPessoa(

        @NotNull
        Long id,

        String nome,

        LocalDate dataNascimento
) {
}