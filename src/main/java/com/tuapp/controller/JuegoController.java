package com.tuapp.controller;

import com.tuapp.model.Juegos;
import com.tuapp.service.JuegoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/juegos")
public class JuegoController {

    // Volvemos a usar Inyección de Dependencias para traer el Service
    @Autowired
    private JuegoService service;

    // Endpoint para guardar (POST: http://localhost:8080/api/juegos)
    @PostMapping
    public Juegos crear(@Valid @RequestBody Juegos juegos) {
        return service.guardarJuego(juegos);
    }

    // Endpoint para listar (GET: http://localhost:8080/api/juegos)
    @GetMapping
    public List<Juegos> listarTodos() {
        return service.obtenerTodos();
    }

    // Endpoint para buscar por ID (GET: http://localhost:8080/api/juegos/{id})
    @GetMapping("/{id}")
    public Juegos obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    // Endpoint para actualizar por ID (PUT: http://localhost:8080/api/juegos/{id})
    @PutMapping("/{id}")
    public Juegos actualizar(@PathVariable Long id, @Valid @RequestBody Juegos juegos) {
        return service.actualizarJuego(id, juegos);
    }

    // Endpoint para eliminar por ID (DELETE: http://localhost:8080/api/juegos/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
