package com.example.conexionPractica.Repository;

import com.example.conexionPractica.Model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMascotaRepository extends JpaRepository<Mascota, Long> {
}
