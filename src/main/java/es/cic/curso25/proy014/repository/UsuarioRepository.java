package es.cic.curso25.proy014.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.cic.curso25.proy014.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario,Long>{

}
