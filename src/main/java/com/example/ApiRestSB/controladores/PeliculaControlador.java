package com.example.ApiRestSB.controladores;

import com.example.ApiRestSB.modelos.Pelicula;
import com.example.ApiRestSB.repositorios.PeliculaRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PeliculaControlador {

    PeliculaRepositorio repositorio;

    public PeliculaControlador(PeliculaRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @GetMapping("/api/crearPeliculas")
    public void crearPeliculas(){
        Pelicula pelicula1 = new Pelicula("Up","Pete Docter", "La película cuenta la historia de Carl Fredricksen, un viudo de 78 años que decide cumplir el sueño que compartía con su difunta esposa: viajar a Paradise Falls, en América del Sur. Para lograrlo, amarra miles de globos a su casa y emprende el vuelo, pero sin darse cuenta, lleva consigo a un joven entusiasta llamado Russell. Juntos, enfrentan aventuras llenas de emoción, peligro y lecciones sobre el valor de la amistad, los sueños y las segundas oportunidades.", "Animacion, Aventura, Comedia");
        Pelicula pelicula2 = new Pelicula("Toy Story", "John Lasseter", "Una historia entrañable sobre un grupo de juguetes que cobran vida cuando los humanos no están presentes. Woody, un vaquero de juguete, disfruta siendo el favorito de Andy, hasta que llega Buzz Lightyear, un moderno guardián del espacio que amenaza su posición. Ambos deben superar sus diferencias y trabajar juntos en una emocionante aventura.", "Animación, Comedia, Aventura.");
        Pelicula pelicula3 = new Pelicula("Wall-E", "Andrew Stanton", "En un futuro distante, la Tierra ha sido abandonada y cubierta de basura. WALL-E, un solitario robot compactador, continúa su trabajo limpiando el planeta. Todo cambia cuando conoce a EVE, una elegante robot exploradora, y juntos emprenden un viaje que podría cambiar el destino de la humanidad.", "Animación, Ciencia ficción, Romance.");

        repositorio.save(pelicula1);
        repositorio.save(pelicula2);
        repositorio.save(pelicula3);
    }

    @GetMapping("/api/peliculas")
    public List<Pelicula> obtenerPeliculas(){
        return repositorio.findAll();
    }

}
