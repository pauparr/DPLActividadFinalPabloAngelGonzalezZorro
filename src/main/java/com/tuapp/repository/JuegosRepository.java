package com.tuapp.repository;

import com.tuapp.model.Juegos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegosRepository extends JpaRepository<Juegos, Long> {

}
