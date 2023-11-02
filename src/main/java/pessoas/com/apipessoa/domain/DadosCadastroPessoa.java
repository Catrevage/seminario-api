package pessoas.com.apipessoa.domain;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;

public record DadosCadastroPessoa(
        @NotBlank @NotBlank
        String nome,

        @NotNull
        LocalDate dataNascimento

) {
}