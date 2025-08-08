package es.cic.curso25.proy014.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import es.cic.curso25.proy014.repository.GarajeRepository;

import es.cic.curso25.proy014.model.Garaje;

@Service
@Transactional
public class GarajeService {

    @Autowired
    private GarajeRepository GarajeRepository;

    @Transactional(readOnly = true)
    public Optional<Garaje> get(Long Id) {
        return GarajeRepository.findById(Id);
    }

    public Garaje create(Garaje garaje) {
        return GarajeRepository.saveAndFlush(garaje);
    }

    public Garaje update(Garaje garaje) {
        return GarajeRepository.saveAndFlush(garaje);
    }

    public void delete(Long Id) {
        GarajeRepository.deleteById(Id);
    }

    @Transactional(readOnly = true)
    public List<Garaje> getAll() {
        return GarajeRepository.findAll();
    }

}
