package org.iesvdm.pruebaud3.dao;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.iesvdm.pruebaud3.modelo.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@AllArgsConstructor
public class PeliculaDAOImpl implements PeliculaDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Pelicula> getAll() {

        List<Pelicula> listPeliculas = jdbcTemplate.query(
                "SELECT * FROM pelicula",
                (rs, rowNum) -> new Pelicula(rs.getInt("id_pelicula"),
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getDate("fecha_lanzamiento"),
                        rs.getInt("id_idioma"),
                        rs.getInt("duracion_alquiler"),
                        rs.getBigDecimal("rental_rate"),
                        rs.getInt("duracion"),
                        rs.getBigDecimal("replacement_cost"),
                        rs.getDate("ultima_actualizacion"))

        );

        log.info("Devueltos {} registros.", listPeliculas.size());

        return listPeliculas;

    }

    @Override
    public void update(Pelicula pelicula) {

    }

    @Override
    public void create(Pelicula pelicula) {

        String sqlInsert = """
							INSERT INTO pelicula (titulo, descripcion, fecha_lanzamiento, id_idioma, duracion_alquiler
							, rental_rate, duracion, replacement_cost, ultima_actualizacion) 
							VALUES  (     ?,         ?,         ?,         ? ,         ?,         ?,         ?,         ?,      ?)
						   """;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        //Con recuperación de id generado
        int rows = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[] { "id_pelicula" });
            int idx = 1;
            ps.setString(idx++, pelicula.getTitulo());
            ps.setString(idx++, pelicula.getDescripcion());
            Date fechaLaunch = new Date(pelicula.getFecha_lanzamiento().getTime()); // SQL <-> (JAVA.UTIL)
            ps.setDate(idx++, fechaLaunch);
            ps.setInt(idx,  pelicula.getId_idioma());
            ps.setInt(idx,  pelicula.getDuracion_alquiler());
            ps.setBigDecimal(idx,  pelicula.getRental_rate());
            ps.setInt(idx,  pelicula.getDuracion());
            ps.setBigDecimal(idx,  pelicula.getReplacement_cost());
            Date ult_act = new Date(pelicula.getUltima_actualizacion().getTime()); // SQL <-> (JAVA.UTIL)
            ps.setDate(idx++, ult_act);
            return ps;
        },keyHolder);

        pelicula.setId_pelicula(keyHolder.getKey().intValue());

        //Podemos recuperar el id

        log.info("Insertados {} registros.", rows);


    }

    @Override
    public Optional<Pelicula> find(int id) {
        return Optional.empty();
    }

    @Override
    public void delete(long id) {

    }
}
