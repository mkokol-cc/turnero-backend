package com.sistema.examenes.repositorios.mios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.examenes.modelo.mios.TipoPlan;

@Repository
public interface TipoPlanRepository extends JpaRepository<TipoPlan,Long>{

}