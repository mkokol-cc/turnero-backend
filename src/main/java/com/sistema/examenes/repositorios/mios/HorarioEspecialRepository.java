package com.sistema.examenes.repositorios.mios;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.examenes.modelo.mios.AsignacionRecursoTipoTurno;
import com.sistema.examenes.modelo.mios.Dias;
import com.sistema.examenes.modelo.mios.HorarioEspecial;

@Repository
public interface HorarioEspecialRepository extends JpaRepository<HorarioEspecial,Long>{

	List<HorarioEspecial> findByAsignacion(AsignacionRecursoTipoTurno asignacion);
	
	List<HorarioEspecial> findByAsignacionAndFecha(AsignacionRecursoTipoTurno asignacion, Date fecha);
	
}
