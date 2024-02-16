package org.iesvdm.pruebarecuud3.dao;

import org.iesvdm.pruebarecuud3.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaDAOImpl implements PersonaDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Persona> getAll() {

        List<Persona> listProf = jdbcTemplate.query(
                "SELECT * FROM persona where tipo = 'catedratico' or tipo = 'profesor' ",
                (rs, rowNum) -> new Persona(rs.getInt("id"),rs.getString("nif"), rs.getString("nombre"), rs.getString("apellido1"), rs.getString("apellido2"), rs.getString("ciudad"), rs.getString("direccion"), rs.getString("telefono"), rs.getDate("fecha_nacimiento"), rs.getString("tipo"))
        );

        return listProf;

    }

    @Override
    public synchronized void create(Persona persona) {

        jdbcTemplate.update("INSERT INTO persona (nif, nombre, apellido1, apellido2, ciudad, direccion, telefono, fecha_nacimiento, tipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",persona.getNif(), persona.getNombre(), persona.getApellido1(), persona.getApellido2(), persona.getCiudad(), persona.getDireccion(), persona.getTelefono(), persona.getFechaNacimiento(), persona.getTipo());

    }
}
