package com.ceiba.gestionparqueadero.infraestructura.persistencia.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


@Entity(name ="ACTIVIDADES")
@NamedQuery(name="Actividades.byEstado" , query="SELECT act FROM ACTIVIDADES act WHERE act.estado='A'")
@NamedQuery(name="Actividades.byId", query="SELECT act FROM ACTIVIDADES act WHERE act.estado='A' AND"
		+ " act.id = :id")
public class ActividadEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "HORA_ENTRA")
	private Date horaEntra;
	
	@Column(name = "HORA_SALE")
	private String horaSale;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="REGISTRO_ID")
	private RegistroAutomotorEntity registroAutomotorEntity;
	
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name = "BONO")
	private String bono;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public Date getHoraEntra() {
		if (this.horaEntra != null) {
	        return new Date(this.horaEntra.getTime());
	    } else {
	        return null;
	    }
	}

	public void setHoraEntra(Date horaEntra) {
		this.horaEntra = horaEntra != null ? new Date(horaEntra.getTime()) : horaEntra;
	}

	public String getHoraSale() {
		return horaSale;
	}

	public void setHoraSale(String horaSale) {
		this.horaSale = horaSale;
	}
	public RegistroAutomotorEntity getRegistroAutomotorEntity() {
		return registroAutomotorEntity;
	}

	public void setRegistroAutomotorEntity(RegistroAutomotorEntity registroAutomotorEntity) {
		this.registroAutomotorEntity = registroAutomotorEntity;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getBono() {
		return bono;
	}

	public void setBono(String bono) {
		this.bono = bono;
	}
	
}
