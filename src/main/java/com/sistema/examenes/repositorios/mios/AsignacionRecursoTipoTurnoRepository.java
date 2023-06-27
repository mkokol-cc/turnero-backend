package com.sistema.examenes.repositorios.mios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.examenes.modelo.mios.AsignacionRecursoTipoTurno;
import com.sistema.examenes.modelo.mios.Recurso;
import com.sistema.examenes.modelo.mios.TipoTurno;

public interface AsignacionRecursoTipoTurnoRepository extends JpaRepository<AsignacionRecursoTipoTurno, Long> {
    AsignacionRecursoTipoTurno findByRecursoAndTipoTurno(Recurso recurso, TipoTurno tipoTurno);
}

