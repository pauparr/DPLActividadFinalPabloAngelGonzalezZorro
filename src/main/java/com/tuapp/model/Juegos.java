package com.tuapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "juegos")
@Data
    public class Juegos {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombre;

        private String categoria;

        private String estudio;

}
