package com.example.conexionPractica.Controller;

import com.example.conexionPractica.Model.Persona;
import com.example.conexionPractica.Service.IPersonaService;
import com.example.conexionPractica.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private IPersonaService persoServ;

    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return persoServ.getPersona();
    }

    @PostMapping("/personas/crear")
    public String savePersona(@RequestBody Persona perso){
        persoServ.savePersona(perso);
        return "la persona fue creada correctamente";
    }

    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        persoServ.deletePersona(id);
        return "la persona fue eliminada correctamente";
    }

    @PutMapping("/personas/editar/{id_original}")
    public Persona editPersona(@PathVariable Long id_original,
                               @RequestParam(required = false, name = "id")Long nuevoId,
                               @RequestParam(required = false, name = "nombre")String nuevoNombre,
                               @RequestParam(required = false, name = "apellido")String nuevoApellido,
                               @RequestParam(required = false, name = "edad")int nuevoEdad){

        persoServ.editPersona(id_original, nuevoId, nuevoNombre, nuevoApellido, nuevoEdad);

        Persona perso = persoServ.findPersona(nuevoId);

        return perso;
    }

    @PutMapping("/personas/editar")
    public Persona editPersona(@RequestBody Persona per){
        persoServ.editPersona(per);

        return persoServ.findPersona(per.getId());
    }
}
