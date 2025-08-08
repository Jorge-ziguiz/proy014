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

import es.cic.curso25.proy014.model.Garaje;
import es.cic.curso25.proy014.service.GarajeService;

@RestController
@RequestMapping(path = "garaje")
public class GarajeController {

    @Autowired
    private GarajeService garajeController;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<Garaje> create(@RequestBody Garaje garaje) {
        garaje = garajeController.create(garaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(garaje);
    }



    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Garaje> get(@PathVariable long id) {
        Optional<Garaje> garaje = garajeController.get(Long.valueOf(id));
        Garaje Resultado = garaje.orElseThrow(() -> new RuntimeException("Garaje not found"));
        return ResponseEntity.ok().body(Resultado);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping()
    public ResponseEntity<Garaje> update(@RequestBody Garaje garaje) {
        garaje = garajeController.update(garaje);
        return ResponseEntity.ok().body(garaje);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
         garajeController.delete(Long.valueOf(id));
        return ResponseEntity.ok().body("borrado correctamente");
    }


}
