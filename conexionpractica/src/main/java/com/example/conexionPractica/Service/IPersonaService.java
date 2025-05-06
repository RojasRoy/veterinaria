package com.example.conexionPractica.Service;

import com.example.conexionPractica.Model.Persona;

import java.util.List;

public interface IPersonaService {

    //metodo para traer personas
    //lectura
    public List<Persona> getPersona();

    //alta
    public void savePersona(Persona perso);

    //baja
    public void deletePersona(Long id);

    //lectura de un solo objeto
    public Persona findPersona(Long id);

    //modificacion
    public void editPersona(Long idOriginal, Long idNuevo,
                            String nuevoNombre,
                            String nuevoApellido,
                            int nuevoEdad);

    public void editPersona(Persona per);
}
