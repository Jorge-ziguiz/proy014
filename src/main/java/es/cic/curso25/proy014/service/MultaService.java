package es.cic.curso25.proy014.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso25.proy014.repository.MultaRepository;
import es.cic.curso25.proy014.model.Multa;

@Service
@Transactional
public class MultaService {

    @Autowired
    private MultaRepository multaRepository;

    @Transactional(readOnly = true)
    public Optional<Multa> get(Long Id) {
        return multaRepository.findById(Id);
    }

    public Multa create(Multa multa) {
        return multaRepository.saveAndFlush(multa);
    }

    public Multa update(Multa multa) {
        return multaRepository.saveAndFlush(multa);
    }

    public void delete(Long Id) {
        multaRepository.deleteById(Id);
    }

    @Transactional(readOnly = true)
    public List<Multa> getAll() {
        return multaRepository.findAll();
    }

}
