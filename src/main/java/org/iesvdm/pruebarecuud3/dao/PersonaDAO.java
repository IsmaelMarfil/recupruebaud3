package org.iesvdm.pruebarecuud3.dao;

import org.iesvdm.pruebarecuud3.modelo.Persona;


import java.util.List;

public interface PersonaDAO {
    public List<Persona> getAll();
    public void create(Persona persona);
    //public List<Idioma> getAllIdioma();
    //public List<Pelicula> getPeliculaByIdCategoria(int idCategoria);

}
