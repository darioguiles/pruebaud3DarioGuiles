package org.iesvdm.pruebaud3.controlador;

import jakarta.validation.Valid;
import org.iesvdm.pruebaud3.modelo.Pelicula;
import org.iesvdm.pruebaud3.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PeliculaController {

    @Autowired
   private PeliculaService peliculaService;


    @GetMapping("/peliculas") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
    public String listar(Model model) {

        List<Pelicula> listaPeliculas =  peliculaService.listAll();
        model.addAttribute("listaPeliculas", listaPeliculas);

        return "peliculas";
    }

    @GetMapping("/peliculas/crear") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
    public String crear(Model model) {

        Pelicula pelicula = new Pelicula();
        model.addAttribute("pelicula", pelicula);

        return "crear-pelicula";
    }

    @PostMapping("/peliculas/crear") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
    public String submitCrear(@Valid @ModelAttribute("pelicula") Pelicula pelicula, BindingResult bindingResult, Model model) {


        if (bindingResult.hasErrors()) {
            model.addAttribute("pelicula", pelicula);

            return "crear-pelicula";

        }

        peliculaService.newPelicula(pelicula);

        return "redirect:/pelicula";
    }

}
