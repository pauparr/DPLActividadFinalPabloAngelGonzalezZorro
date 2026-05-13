package com.tuapp.controller;

import com.tuapp.model.Juegos;
import com.tuapp.service.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Juegos crear(@RequestBody Juegos juegos) {
        return service.guardarJuego(juegos);
    }

    // Endpoint para listar (GET: http://localhost:8080/api/juegos)
    @GetMapping
    public List<Juegos> listarTodos() {
        return service.obtenerTodos();
    }
}
