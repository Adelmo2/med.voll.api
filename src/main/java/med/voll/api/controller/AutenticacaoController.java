package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.usuario.DadosAutenticacao;
<<<<<<< HEAD
import med.voll.api.domain.usuario.Usuario;
import med.voll.api.infra.security.TokenService;
=======
>>>>>>> a66742e23c23ce6143200eed4817e14481d87e53
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

<<<<<<< HEAD
    @Autowired
    private TokenService tokenService;

=======
>>>>>>> a66742e23c23ce6143200eed4817e14481d87e53
    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(token);

<<<<<<< HEAD
        //return ResponseEntity.ok().build();
        return ResponseEntity.ok(tokenService.gerarToken((Usuario) authentication.getPrincipal()));
    }

}
=======
        //até a aula 02/03
        //return ResponseEntity.ok().build();
        //Site do JWT - para fazer a autenticação pelo web token.
        //https://jwt.io

        return ResponseEntity.ok("");


    }
}

>>>>>>> a66742e23c23ce6143200eed4817e14481d87e53
