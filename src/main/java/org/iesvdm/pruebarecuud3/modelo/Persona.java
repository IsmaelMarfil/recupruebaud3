package org.iesvdm.pruebarecuud3.modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    private int id;
    @Pattern(regexp = "((([X-Z])|([LM])){1}([-]?)((\\d){7})([-]?)([A-Z]{1}))|((\\d{8})([-]?)([A-Z]))")
    private String nif;
    @NotNull(message = "{noVacio}")
    @NotBlank(message = "{noVacio}")
    @Length(min = 3, message = "{masdetres}")
    private String nombre;
    private String apellido1;
    private String apellido2;
    @Length(max = 25, message = "{menosdeveinticinco}")
    private String ciudad;
    private String direccion;
    private String telefono;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;
    private String tipo;



}
