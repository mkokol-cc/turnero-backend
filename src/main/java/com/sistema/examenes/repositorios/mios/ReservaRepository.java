package com.sistema.examenes.repositorios.mios;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sistema.examenes.modelo.mios.AsignacionRecursoTipoTurno;
import com.sistema.examenes.modelo.mios.Reserva;
import com.sistema.examenes.modelo.mios.Reservante;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Long>{
	//List<Reserva> findByUsuarioId(Long idUsuario);
	List<Reserva> findByAsignacionTipoTurno(AsignacionRecursoTipoTurno asignacionTipoTurno);
	
	List<Reserva> findByAsignacionTipoTurnoAndFecha(AsignacionRecursoTipoTurno asignacionTipoTurno, Date fecha);
	
	List<Reserva> findByAsignacionTipoTurnoAndFechaAndHora(AsignacionRecursoTipoTurno asignacionTipoTurno, Date fecha, Time hora);
	
	@Query("SELECT r.reservante, COUNT(r) FROM Reserva r GROUP BY r.reservante")
	Map<Reservante, Long> countReservasByReservante();


}
