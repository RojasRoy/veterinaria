package com.example.conexionPractica.Service;

import com.example.conexionPractica.Model.Mascota;

import java.util.List;

public interface IMascotaService {

    public List<Mascota> getMascota();

    public void saveMascota(Mascota masco);

    public void deleteMascota(Long id_mascota);

    public Mascota findMascota(Long id_mascota);

    public void editMascota(Long idOriginal, Long id_mascotaNuevo,
                            String nuevoNombre,
                            String nuevoEspecie,
                            String nuevoRaza,
                            String nuevoColor);
}
