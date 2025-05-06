package com.example.conexionPractica.Controller;

import com.example.conexionPractica.Model.Mascota;
import com.example.conexionPractica.Service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MascotaController {

    @Autowired
    private IMascotaService mascotaServ;


    @GetMapping("/mascota/traer")
    public List<Mascota> getMascotas(){
        return mascotaServ.getMascota();
    }

    @PostMapping("/mascota/crear")
    public String saveMascota(@RequestBody Mascota masco){
        mascotaServ.saveMascota(masco);
        return "la mascota fue creada exitosamente";
    }


}
