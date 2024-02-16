package org.iesvdm.pruebarecuud3.controlador;

import jakarta.validation.Valid;
import org.iesvdm.pruebarecuud3.dao.PersonaDAO;
import org.iesvdm.pruebarecuud3.modelo.Persona;
import org.iesvdm.pruebarecuud3.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PersonaController {
    @Autowired
    private PersonaService personaService;
    @Autowired
    private PersonaDAO personaDAO ;
    @GetMapping("/profesores")
    public String listar(Model model) {

        List<Persona> listAllProf =  personaService.listAll();
        model.addAttribute("listaProfesores", listAllProf);
        long conteo=personaService.conteoPersonas();
        model.addAttribute("conteo",conteo);
        //model.addAttribute("listaPeliculasHorror",peliculaDAO.getPeliculaByIdCategoria(5));
        //model.addAttribute("conteoPelisTerror",peliculaService.peliculaPorCategoriaconteo(5));
        return "profesores";

    }

    @GetMapping("/profesores/crear")
    public String crear(Model model) {
        //List<Idioma> listAllIdioma=peliculaService.listAllIdioma();
        Persona persona = new Persona();

        //model.addAttribute("listaIdioma",listAllIdioma);
        model.addAttribute("persona", persona);

        return "crear-profesor";

    }

    @PostMapping("/profesores/crear")
    public String submitCrear(@Valid @ModelAttribute("persona") Persona persona, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            model.addAttribute("persona", persona);
            return "crear-profesor";
        }

        personaService.newPersona(persona);
        return "redirect:/profesores?newPersonaID=" + persona.getId();

    }



}
