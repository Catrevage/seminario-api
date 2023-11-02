package pessoas.com.apipessoa.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<pessoas.com.apipessoa.domain.Pessoa, Long> {
}