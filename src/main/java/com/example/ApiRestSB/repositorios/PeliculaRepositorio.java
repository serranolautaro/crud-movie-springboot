package com.example.ApiRestSB.repositorios;

import com.example.ApiRestSB.modelos.Pelicula;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepositorio extends JpaRepository<Pelicula, Long> {

}
