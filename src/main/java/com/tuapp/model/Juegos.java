package com.tuapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "juegos")
@Data
public class Juegos {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 100, message = "El nombre no puede superar 100 caracteres")
        private String nombre;

        @NotBlank(message = "La categoria es obligatoria")
        @Size(max = 50, message = "La categoria no puede superar 50 caracteres")
        private String categoria;

        @NotBlank(message = "El estudio es obligatorio")
        @Size(max = 100, message = "El estudio no puede superar 100 caracteres")
        private String estudio;

}
