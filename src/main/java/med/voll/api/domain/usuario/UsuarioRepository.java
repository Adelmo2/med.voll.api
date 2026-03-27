package med.voll.api.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
<<<<<<< HEAD
=======

>>>>>>> a66742e23c23ce6143200eed4817e14481d87e53
    UserDetails findByLogin(String login);
}
