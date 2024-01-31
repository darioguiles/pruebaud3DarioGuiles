package org.iesvdm.pruebaud3.modelo;


import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {


    @Min(value=1, message = "{msg.valid.min}")
    private int id_pelicula;

    @NotNull(message = "{msg.valid.not.null}")
    @Length(min = 1)
    private String titulo;

    @Length(max = 255)
    private String descripcion;
    private Date fecha_lanzamiento;

    @Min(value=1, message = "{msg.valid.min}")
    private int id_idioma;

    @Min(value=1, message = "{msg.valid.min}")
    private int duracion_alquiler;

    @DecimalMin(value="0.0", message = "{msg.valid.min}")
    private BigDecimal rental_rate; // (4,2) = 4,99

    @Min(value = 1)
    private int duracion;

    @DecimalMin(value="19.99", message = "{msg.valid.min}")
    private BigDecimal replacement_cost; // (5,2) = 19,99

    @NotNull(message = "{msg.valid.not.null}")
    private Date ultima_actualizacion; //current Time
}
