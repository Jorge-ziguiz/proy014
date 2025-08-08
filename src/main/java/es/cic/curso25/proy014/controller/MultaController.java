package es.cic.curso25.proy014.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso25.proy014.model.Multa;
import es.cic.curso25.proy014.service.MultaService;

@RestController
@RequestMapping(path = "multa")
public class MultaController {

    @Autowired
    private MultaService multaService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<Multa> create(@RequestBody Multa Multa) {
        Multa = multaService.create(Multa);
        return ResponseEntity.status(HttpStatus.CREATED).body(Multa);
    }



    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Multa> get(@PathVariable long id) {
        Optional<Multa> Multa = multaService.get(Long.valueOf(id));
        Multa Resultado = Multa.orElseThrow(() -> new RuntimeException("Multa not found"));
        return ResponseEntity.ok().body(Resultado);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping()
    public ResponseEntity<Multa> update(@RequestBody Multa Multa) {
        Multa = multaService.update(Multa);
        return ResponseEntity.ok().body(Multa);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
         multaService.delete(Long.valueOf(id));
        return ResponseEntity.ok().body("borrado correctamente");
    }


}
