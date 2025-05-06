package com.example.conexionPractica.Service;

import com.example.conexionPractica.Model.Mascota;
import com.example.conexionPractica.Repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService implements IMascotaService{

    @Autowired
    private IMascotaRepository mascotaRepo;

    @Override
    public List<Mascota> getMascota() {
        List<Mascota> listaMascotas = mascotaRepo.findAll();
        return listaMascotas;
    }

    @Override
    public void saveMascota(Mascota masco) {
        mascotaRepo.save(masco);
    }

    @Override
    public void deleteMascota(Long id_mascota) {
        mascotaRepo.deleteById(id_mascota);
    }

    @Override
    public Mascota findMascota(Long id_mascota) {
        Mascota masco = mascotaRepo.findById(id_mascota).orElse(null);
        return masco;
    }

    @Override
    public void editMascota(Long idOriginal, Long id_mascotaNuevo, String nuevoNombre, String nuevoEspecie, String nuevoRaza, String nuevoColor) {
        Mascota masco = this.findMascota(idOriginal);

        masco.setId_mascota(id_mascotaNuevo);
        masco.setNombre(nuevoNombre);
        masco.setEspecie(nuevoEspecie);
        masco.setRaza(nuevoRaza);
        masco.setColor(nuevoColor);

        this.saveMascota(masco);
    }
}
