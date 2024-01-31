package org.iesvdm.pruebaud3.dao;

import org.iesvdm.pruebaud3.modelo.Pelicula;

import java.util.List;
import java.util.Optional;

public interface PeliculaDAO {

    public List<Pelicula> getAll();

    public void update(Pelicula pelicula);
    public void create(Pelicula pelicula);

    public Optional<Pelicula> find(int id);

    public void delete(long id);

}
