package es.cic.curso25.proy014.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso25.proy014.repository.CocheRepository;
import es.cic.curso25.proy014.model.Coche;

@Service
@Transactional
public class CocheService {

    @Autowired
    private CocheRepository cocheRepository;

    @Transactional(readOnly = true)
    public Optional<Coche> get(Long Id) {
        return cocheRepository.findById(Id);
    }

    public Coche create(Coche coche) {
        return cocheRepository.saveAndFlush(coche);
    }

    public Coche update(Coche coche) {
        return cocheRepository.saveAndFlush(coche);
    }

    public void delete(Long Id) {
        cocheRepository.deleteById(Id);
    }

    @Transactional(readOnly = true)
    public List<Coche> getAll() {
        return cocheRepository.findAll();
    }

}
