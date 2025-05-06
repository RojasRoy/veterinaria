package com.example.conexionPractica.Service;

import com.example.conexionPractica.Model.Persona;
import com.example.conexionPractica.Repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private IPersonaRepository personaRepo;

    @Override
    public List<Persona> getPersona() {
        List<Persona> listaPersona = personaRepo.findAll();
        return listaPersona;
    }

    @Override
    public void savePersona(Persona perso) {
        personaRepo.save(perso);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona perso = personaRepo.findById(id).orElse(null);
        return perso;
    }

    @Override
    public void editPersona(Long idOriginal, Long idNuevo, String nuevoNombre, String nuevoApellido, int nuevoEdad) {
        Persona perso = this.findPersona(idOriginal);

        perso.setId(idNuevo);
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        perso.setEdad(nuevoEdad);

        this.savePersona(perso);
    }

    @Override
    public void editPersona(Persona per) {
        this.savePersona(per);
    }
}
