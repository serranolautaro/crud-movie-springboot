package com.example.ApiRestSB.controladores;

import com.example.ApiRestSB.modelos.Pelicula;
import com.example.ApiRestSB.repositorios.PeliculaRepositorio;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PeliculaControlador {

    PeliculaRepositorio repositorio;

    public PeliculaControlador(PeliculaRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @GetMapping("/api/crearPeliculas")
    public void crearPeliculas(){
        Pelicula pelicula1 = new Pelicula("Up","Pete Docter","Animacion, Aventura, Comedia");
        Pelicula pelicula2 = new Pelicula("Toy Story", "John Lasseter", "Animación, Comedia, Aventura.");
        Pelicula pelicula3 = new Pelicula("Wall-E", "Andrew Stanton", "Animación, Ciencia ficción, Romance.");

        repositorio.save(pelicula1);
        repositorio.save(pelicula2);
        repositorio.save(pelicula3);
    }

    @GetMapping("/api/peliculas")
    public List<Pelicula> obtenerPeliculas(){
        return repositorio.findAll();
    }

    @GetMapping("/api/traerUnaPelicula/{id}")
    public ResponseEntity<Pelicula> obtenerPelicula(@PathVariable Long id){
        Optional<Pelicula> opt = repositorio.findById(id);

        if(opt.isEmpty()){
            return ResponseEntity.badRequest().build();
        }else
            return ResponseEntity.ok(opt.get());
    }

    @PostMapping("/api/peliculas")
    public ResponseEntity guardarPelicula(@RequestBody Pelicula pelicula){
        if(pelicula.getId() != null){
            return ResponseEntity.badRequest().build();
        } else
            return ResponseEntity.ok(pelicula);
    }

}
