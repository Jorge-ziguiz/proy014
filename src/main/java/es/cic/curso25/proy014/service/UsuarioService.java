package es.cic.curso25.proy014.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso25.proy014.repository.UsuarioRepository;
import es.cic.curso25.proy014.model.Usuario;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public Optional<Usuario> get(Long Id) {
        return usuarioRepository.findById(Id);
    }

    public Usuario create(Usuario usuario) {
        return usuarioRepository.saveAndFlush(usuario);
    }

    public Usuario update(Usuario usuario) {
        return usuarioRepository.saveAndFlush(usuario);
    }

    public void delete(Long Id) {
        usuarioRepository.deleteById(Id);
    }

    @Transactional(readOnly = true)
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

}
