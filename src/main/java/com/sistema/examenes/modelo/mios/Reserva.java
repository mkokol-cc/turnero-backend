
package com.sistema.examenes.modelo.mios;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sistema.examenes.modelo.mios.state.Estado;

/**
 * @author MATIAS
 * @version 1.0
 * @created 17-ene-2023 02:55:43 p.m.
 */

@Entity
@Table(name = "reserva")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="tipoReserva")
	private String tipoReserva;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estado", referencedColumnName = "id", nullable = false, unique = false)
	//@JsonManagedReference
	private Estado estado;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha",nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	@Column(name = "hora",nullable = false)
	private Time hora;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "asignacionTipoTurno", referencedColumnName = "id", nullable = false, unique = false)
	//@JsonManagedReference
	private AsignacionRecursoTipoTurno asignacionTipoTurno;
	
	
	@OneToMany(mappedBy="reserva")
	@Column(name = "cambioEstado",nullable=true)
	@JsonBackReference
	@JsonIgnore
	public List<CambioEstado> cambioEstado;
	
	@Column(name="nota")
	private String nota;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reservante", referencedColumnName = "id", nullable = false, unique = false)
	//@JsonManagedReference
	private Reservante reservante;
	
	public Reserva(){

	}

	public void finalize() throws Throwable {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public AsignacionRecursoTipoTurno getTipoTurno() {
		return asignacionTipoTurno;
	}

	public void setTipoTurno(AsignacionRecursoTipoTurno asignacionTipoTurno) {
		this.asignacionTipoTurno = asignacionTipoTurno;
	}

	public String getTipoReserva() {
		return tipoReserva;
	}

	public void setTipoReserva(String tipoReserva) {
		this.tipoReserva = tipoReserva;
	}

	public AsignacionRecursoTipoTurno getAsignacionTipoTurno() {
		return asignacionTipoTurno;
	}

	public void setAsignacionTipoTurno(AsignacionRecursoTipoTurno asignacionTipoTurno) {
		this.asignacionTipoTurno = asignacionTipoTurno;
	}

	public List<CambioEstado> getCambioEstado() {
		return cambioEstado;
	}

	public void setCambioEstado(List<CambioEstado> cambioEstado) {
		this.cambioEstado = cambioEstado;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Reservante getReservante() {
		return reservante;
	}

	public void setReservante(Reservante reservante) {
		this.reservante = reservante;
	}


	
}//end Reserva