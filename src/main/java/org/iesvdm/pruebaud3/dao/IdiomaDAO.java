package org.iesvdm.pruebaud3.dao;

import org.iesvdm.pruebaud3.modelo.Idioma;
import org.iesvdm.pruebaud3.modelo.Pelicula;

import java.util.List;
import java.util.Optional;

public interface IdiomaDAO {

    public List<Idioma> getAll();

    public void update(Idioma idioma);
    public void create(Idioma idioma);

    public Optional<Idioma> find(int id);

    public void delete(long id);
}
