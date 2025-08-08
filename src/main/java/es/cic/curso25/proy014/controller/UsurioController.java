package es.cic.curso25.proy014.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso25.proy014.dto.CrearCoche;
import es.cic.curso25.proy014.model.Coche;
import es.cic.curso25.proy014.service.CocheService;

@RestController
@RequestMapping(path = "usuario")
public class UsurioController {

    @Autowired
    private CocheService cocheService;

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PostMapping()
    public ResponseEntity<Coche> registrarUnNuevoCocheAlGaraje(@RequestBody CrearCoche coche) {
        Coche ressultao = cocheService.createCocheUser(coche);
        return ResponseEntity.status(HttpStatus.CREATED).body(ressultao);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Coche> buscarMyCocheEnGaraje(@PathVariable long id) {
        Optional<Coche> coche = cocheService.get(Long.valueOf(id));
        Coche Resultado = coche.orElseThrow(() -> new RuntimeException("Coche not found"));
        return ResponseEntity.ok().body(Resultado);
    }
    
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping(path = "/{id}/multas")
    public ResponseEntity<Coche> verMisMultas(@PathVariable long id) {
        Optional<Coche> coche = cocheService.get(Long.valueOf(id));
        Coche Resultado = coche.orElseThrow(() -> new RuntimeException("Coche not found"));
        return ResponseEntity.ok().body(Resultado);
    }

    
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PutMapping()
    public ResponseEntity<Coche> meterCocheAlGaraje(@RequestBody Coche coche) {
        coche = cocheService.update(coche);
        return ResponseEntity.ok().body(coche);
    }

}
