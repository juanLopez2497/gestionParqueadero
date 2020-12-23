package com.ceiba.gestionparqueadero.infraestructura.persistencia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name ="FACTURA")
public class FacturaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "ID_ACT")
	private Long idActividadEntity;
	
	@Column(name = "TOTAL_PAGADO")
	private double valorPagado;

	public Long getId() {
		return id;
	}

	public Long getIdActividadEntity() {
		return idActividadEntity;
	}

	public void setIdActividadEntity(Long idActividadEntity) {
		this.idActividadEntity = idActividadEntity;
	}

	public double getValorPagado() {
		return valorPagado;
	}

	public void setValorPagado(double valorPagado) {
		this.valorPagado = valorPagado;
	}
	
}
