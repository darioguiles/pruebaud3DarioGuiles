package org.iesvdm.pruebaud3.service;


import org.iesvdm.pruebaud3.dao.PeliculaDAO;
import org.iesvdm.pruebaud3.modelo.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaDAO peliculaDAO;

    public List<Pelicula> listAll(){
        return peliculaDAO.getAll();
    }

    public void newPelicula(Pelicula peli) {
        peliculaDAO.create(peli);
    }


}
