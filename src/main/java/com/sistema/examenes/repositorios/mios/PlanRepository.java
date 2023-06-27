package com.sistema.examenes.repositorios.mios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.examenes.modelo.mios.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan,Long>{

}
