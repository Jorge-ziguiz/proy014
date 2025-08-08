package es.cic.curso25.proy014.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso25.proy014.model.Coche;
import es.cic.curso25.proy014.service.CocheService;

@RestController
@RequestMapping(path = "coche")
public class CocheController {

    @Autowired
    private CocheService cocheService;

    @PostMapping()
    public ResponseEntity<Coche> create(@RequestBody Coche coche) {
        coche = cocheService.create(coche);
        return ResponseEntity.status(HttpStatus.CREATED).body(coche);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Coche> get(@PathVariable long id) {
        Optional<Coche> coche = cocheService.get(Long.valueOf(id));
        Coche Resultado = coche.orElseThrow(() -> new RuntimeException("Coche not found"));
        return ResponseEntity.ok().body(Resultado);
    }

    @PutMapping()
    public ResponseEntity<Coche> update(@RequestBody Coche coche) {
        coche = cocheService.update(coche);
        return ResponseEntity.ok().body(coche);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
         cocheService.delete(Long.valueOf(id));
        return ResponseEntity.ok().body("borrado correctamente");
    }


}
