package com.sistema.examenes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.sistema.examenes.modelo.mios.AsignacionRecursoTipoTurno;
import com.sistema.examenes.modelo.mios.Horario;
import com.sistema.examenes.modelo.mios.Recurso;
import com.sistema.examenes.modelo.mios.TipoTurno;
import com.sistema.examenes.repositorios.mios.AsignacionRecursoTipoTurnoRepository;
import com.sistema.examenes.repositorios.mios.HorarioRepository;
import com.sistema.examenes.repositorios.mios.RecursoRepository;
import com.sistema.examenes.repositorios.mios.TipoTurnoRepository;

@SpringBootTest
class SistemaExamenesBackendApplicationTests {
	@Autowired
	private RecursoRepository repo;
	
	@Autowired
	private TipoTurnoRepository tipoTurnoRepo;
	
	@Autowired
	private HorarioRepository horarioRepo;
	
	@Autowired
	private AsignacionRecursoTipoTurnoRepository asignacionRepo;
	
	@Test
	void contextLoads() {

	}

}
