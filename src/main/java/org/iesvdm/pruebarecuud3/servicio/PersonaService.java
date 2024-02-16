package org.iesvdm.pruebarecuud3.servicio;

import org.iesvdm.pruebarecuud3.dao.PersonaDAO;
import org.iesvdm.pruebarecuud3.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaDAO personaDAO;

    public List<Persona> listAll() {

        return personaDAO.getAll();


    }
    public void newPersona(Persona persona) {

        personaDAO.create(persona);

    }

    public long conteoPersonas(){
        List<Persona> listadoPersonas=personaDAO.getAll();
        long conteo=listadoPersonas.stream().count();
        return conteo;
    }

}
