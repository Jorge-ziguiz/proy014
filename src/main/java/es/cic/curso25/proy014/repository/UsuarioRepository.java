package es.cic.curso25.proy014.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.cic.curso25.proy014.model.Coche;
import es.cic.curso25.proy014.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario,Long>{


}
