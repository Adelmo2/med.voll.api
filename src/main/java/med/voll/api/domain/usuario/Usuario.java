package med.voll.api.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
<<<<<<< HEAD
=======
import org.jspecify.annotations.Nullable;
>>>>>>> a66742e23c23ce6143200eed4817e14481d87e53
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;

<<<<<<< HEAD
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
=======
    //Controle perfis de usuarios
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //return List.of();
>>>>>>> a66742e23c23ce6143200eed4817e14481d87e53
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
<<<<<<< HEAD
    public String getPassword() {
=======
    public @Nullable String getPassword() {
        //return "";
>>>>>>> a66742e23c23ce6143200eed4817e14481d87e53
        return senha;
    }

    @Override
    public String getUsername() {
<<<<<<< HEAD
=======
        //return "";
>>>>>>> a66742e23c23ce6143200eed4817e14481d87e53
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
<<<<<<< HEAD
=======
        //return UserDetails.super.isAccountNonExpired();
>>>>>>> a66742e23c23ce6143200eed4817e14481d87e53
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
<<<<<<< HEAD
=======
        //return UserDetails.super.isAccountNonLocked();
>>>>>>> a66742e23c23ce6143200eed4817e14481d87e53
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
<<<<<<< HEAD
=======
        //return UserDetails.super.isCredentialsNonExpired();
>>>>>>> a66742e23c23ce6143200eed4817e14481d87e53
        return true;
    }

    @Override
    public boolean isEnabled() {
<<<<<<< HEAD
=======
        //return UserDetails.super.isEnabled();
>>>>>>> a66742e23c23ce6143200eed4817e14481d87e53
        return true;
    }
}
