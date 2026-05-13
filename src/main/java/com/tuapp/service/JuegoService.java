package com.tuapp.service;

import com.tuapp.model.Juegos;
import com.tuapp.repository.JuegosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuegoService {

    @Autowired
    private JuegosRepository repository;

    // Crear un Juego en base de datos
    public Juegos guardarJuego(Juegos juegos) {
        return repository.save(juegos);
    }

    // Obtener todos los Juegos de la base de datos
    public List<Juegos> obtenerTodos() {
        return repository.findAll();
    }
}
