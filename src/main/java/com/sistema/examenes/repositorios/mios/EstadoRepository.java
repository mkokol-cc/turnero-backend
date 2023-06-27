package com.sistema.examenes.repositorios.mios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.examenes.modelo.mios.state.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Long>{

}
