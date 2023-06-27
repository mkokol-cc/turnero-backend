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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "AsignacionRecursoTipoTurno")
@JsonIgnoreProperties({"defaultReference"})
public class AsignacionRecursoTipoTurno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_recurso")
    private Recurso recurso;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_tipoTurno")
    private TipoTurno tipoTurno;
    
    @OneToMany(mappedBy = "asignacion", fetch = FetchType.EAGER/*, cascade = CascadeType.ALL, orphanRemoval = true*/)
    //@JsonIgnore
    private Set<Horario> horarios = new HashSet<>();
	
    @OneToMany(mappedBy = "asignacion", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<HorarioEspecial> horariosEspeciales;

	@Column(name = "cantidadConcurrencia",nullable=false)
	private int cantidadConcurrencia;
	
	@Column(name = "eliminado")
	private boolean eliminado;
	
	
	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "asignacion_recurso_tipo_turno_simultaneo",
	    joinColumns = @JoinColumn(name = "id_asignacion_recurso_tipo_turno"),
	    inverseJoinColumns = @JoinColumn(name = "id_asignacion_recurso_tipo_turno_simultaneo"))
	private Set<AsignacionRecursoTipoTurno> simultaneos = new HashSet<>();//un recurso especifico puede tener tipos de turnos que sean simultaneos

	@OneToMany(mappedBy="asignacionTipoTurno", orphanRemoval = true)
	@Column(name = "reservas",nullable=true)
	//@JsonIgnore
	public Set<Reserva> reservas;
	
	
	@Column(name = "duracionEnMinutos",nullable=true)
	private int duracionEnMinutos;
	
	@Column(name = "seniaCtvs",nullable=true)
	private int seniaCtvos;
	
	@Column(name = "precioEstimadoDesdeCtvos",nullable=true)
	private int precioEstimadoDesdeCtvos;
	
	@Column(name = "precioEstimadoHastaCtvos",nullable=true)
	private int precioEstimadoHastaCtvos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public TipoTurno getTipoTurno() {
		return tipoTurno;
	}

	public void setTipoTurno(TipoTurno tipoTurno) {
		this.tipoTurno = tipoTurno;
	}

	public Set<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(Set<Horario> horarios) {
		this.horarios = horarios;
	}

	public Set<HorarioEspecial> getHorariosEspeciales() {
		return horariosEspeciales;
	}

	public void setHorariosEspeciales(Set<HorarioEspecial> horariosEspeciales) {
		this.horariosEspeciales = horariosEspeciales;
	}

	public int getCantidadConcurrencia() {
		return cantidadConcurrencia;
	}

	public void setCantidadConcurrencia(int cantidadConcurrencia) {
		this.cantidadConcurrencia = cantidadConcurrencia;
	}

	public Set<AsignacionRecursoTipoTurno> getSimultaneos() {
		return simultaneos;
	}

	public void setSimultaneos(Set<AsignacionRecursoTipoTurno> simultaneos) {
		this.simultaneos = simultaneos;
	}

	public Set<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}

	public int getDuracionEnMinutos() {
		return duracionEnMinutos;
	}

	public void setDuracionEnMinutos(int duracionEnMinutos) {
		this.duracionEnMinutos = duracionEnMinutos;
	}

	public int getSeniaCtvos() {
		return seniaCtvos;
	}

	public void setSeniaCtvos(int seniaCtvos) {
		this.seniaCtvos = seniaCtvos;
	}

	public int getPrecioEstimadoDesdeCtvos() {
		return precioEstimadoDesdeCtvos;
	}

	public void setPrecioEstimadoDesdeCtvos(int precioEstimadoDesdeCtvos) {
		this.precioEstimadoDesdeCtvos = precioEstimadoDesdeCtvos;
	}

	public int getPrecioEstimadoHastaCtvos() {
		return precioEstimadoHastaCtvos;
	}

	public void setPrecioEstimadoHastaCtvos(int precioEstimadoHastaCtvos) {
		this.precioEstimadoHastaCtvos = precioEstimadoHastaCtvos;
	}
	
	
}
