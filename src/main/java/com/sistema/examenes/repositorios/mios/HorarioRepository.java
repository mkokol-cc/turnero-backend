package com.sistema.examenes.repositorios.mios;

import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.examenes.modelo.mios.AsignacionRecursoTipoTurno;
import com.sistema.examenes.modelo.mios.Dias;
import com.sistema.examenes.modelo.mios.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario,Long>{

	List<Horario> findByAsignacion(AsignacionRecursoTipoTurno asignacion);
	
	List<Horario> findByAsignacionAndDia(AsignacionRecursoTipoTurno asignacion, Dias dia);
	
}
