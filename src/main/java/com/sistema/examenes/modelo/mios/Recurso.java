package com.sistema.examenes.modelo.mios;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author MATIAS
 * @version 1.0
 * @created 17-ene-2023 02:55:43 p.m.
 */

@Entity
@Table(name = "recurso")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Recurso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descripcion;
	private String nombre;
	
	@OneToMany(mappedBy = "recurso", cascade = CascadeType.ALL, orphanRemoval = true)
	@Fetch(FetchMode.SUBSELECT)
	@JsonIgnore
	private List<AsignacionRecursoTipoTurno> recursosTipoTurno;
	
	
    @OneToMany(mappedBy = "recurso", fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Horario> horarios = new HashSet<>();

	
	@Column(name = "eliminado",nullable=true)
	private boolean eliminado;

	public Recurso(){

	}
	
	public Recurso(String nombre, String descripcion){
		this.nombre=nombre;
		this.descripcion=descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	public List<AsignacionRecursoTipoTurno> getRecursosTipoTurno() {
		return recursosTipoTurno;
	}

	public void setRecursosTipoTurno(List<AsignacionRecursoTipoTurno> recursosTipoTurno) {
		this.recursosTipoTurno = recursosTipoTurno;
	}


	public Set<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(Set<Horario> horarios) {
		this.horarios = horarios;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}

	public void finalize() throws Throwable {

	}
}//end Recurso