package org.example.dplfinalpabloangelgonzalezzorro;

import com.tuapp.model.Juegos;
import com.tuapp.repository.JuegosRepository;
import com.tuapp.service.JuegoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JuegoServiceTest {
    @Mock
    private JuegosRepository repository;
    @InjectMocks
    private JuegoService service;
    private Juegos juegos;

    @BeforeEach
    void setUp() {
        juegos = new Juegos();
        juegos.setId(1L);
        juegos.setNombre("Apex Legends");
        juegos.setCategoria("Battle Royale");
        juegos.setEstudio("Electronic Arts");
    }

    @Test
    void testGuardarJuego() {
        when(repository.save(any(Juegos.class))).thenReturn(juegos);

        Juegos guardado = service.guardarJuego(juegos);

        assertNotNull(guardado);
        assertEquals("Apex Legends", guardado.getNombre());
        verify(repository, times(1)).save(any(Juegos.class));
    }

    @Test
    void testObtenerTodos() {
        when(repository.findAll()).thenReturn(List.of(juegos));

        List<Juegos> lista = service.obtenerTodos();

        assertFalse(lista.isEmpty());
        assertEquals(1, lista.size());
        verify(repository, times(1)).findAll();
    }
}
