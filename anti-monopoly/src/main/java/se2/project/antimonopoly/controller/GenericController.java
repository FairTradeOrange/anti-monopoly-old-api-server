package se2.project.antimonopoly.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se2.project.antimonopoly.service.GenericService;

import java.util.List;

//@Controller
// TODO: TEST
public abstract class GenericController<T, ID> {

    private final GenericService<T, ID> service;

    protected GenericController(GenericService<T, ID> service) {
        if (service == null) {
            throw new IllegalArgumentException("gameDAO must not be null");
        }
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<T>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable ID id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<T> save(@RequestBody T entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable ID id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // Weitere generische Endpunkte können hier implementiert werden.
}
