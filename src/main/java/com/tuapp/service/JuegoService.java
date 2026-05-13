package com.tuapp.service;

import com.tuapp.exception.ResourceNotFoundException;
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

    // Obtener un Juego por ID
    public Juegos obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Juego no encontrado con id: " + id));
    }

    // Actualizar un Juego por ID
    public Juegos actualizarJuego(Long id, Juegos actualizado) {
        Juegos existente = obtenerPorId(id);
        existente.setNombre(actualizado.getNombre());
        existente.setCategoria(actualizado.getCategoria());
        existente.setEstudio(actualizado.getEstudio());
        return repository.save(existente);
    }

    // Eliminar un Juego por ID
    public void eliminarPorId(Long id) {
        Juegos existente = obtenerPorId(id);
        repository.delete(existente);
    }
}
