package org.iesvdm.pruebaud3.dao;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.iesvdm.pruebaud3.modelo.Idioma;
import org.iesvdm.pruebaud3.modelo.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@AllArgsConstructor
public class IdiomaDAOImpl implements IdiomaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Idioma> getAll() {
        List<Idioma> listIdioma = jdbcTemplate.query(
                "SELECT * FROM idioma",
                (rs, rowNum) -> new Idioma(rs.getInt("id_idioma"),
                        rs.getString("nombre"),
                        rs.getDate("ultima_actualizacion"))

        );

        log.info("Devueltos {} registros.", listIdioma.size());

        return listIdioma;
    }

    @Override
    public void update(Idioma idioma) {

    }

    @Override
    public void create(Idioma idioma) {

    }

    @Override
    public Optional<Idioma> find(int id) {
        return Optional.empty();
    }

    @Override
    public void delete(long id) {

    }
}
