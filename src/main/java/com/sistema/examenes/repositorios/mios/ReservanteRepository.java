package com.sistema.examenes.repositorios.mios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.examenes.modelo.mios.Reservante;

public interface ReservanteRepository extends JpaRepository<Reservante,Long>{
	
	Reservante findByTelefono(String telefono);

}

