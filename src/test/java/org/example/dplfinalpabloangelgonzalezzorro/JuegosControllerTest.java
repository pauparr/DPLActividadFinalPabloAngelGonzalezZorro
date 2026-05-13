package com.tuapp.controller;

import com.tuapp.model.Juegos;
import com.tuapp.service.JuegoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JuegoController.class)
public class JuegosControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private JuegoService service;

    @Test
    void testListarTodosEndpoint() throws Exception {
        Juegos juego = new Juegos();
        juego.setNombre("Apex Legends");
        juego.setCategoria("Battle Royale");
        juego.setEstudio("Electronic Arts");
        when(service.obtenerTodos()).thenReturn(List.of(juego));

        mockMvc.perform(get("/api/juegos"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nombre").value("Apex Legends"));
    }
}
