package com.ceiba.gestionparqueadero.infraestructura.persistencia.repositorio;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.ceiba.gestionparqueadero.dominio.FacturaResumen;
import com.ceiba.gestionparqueadero.dominio.repositorio.FacturaRepository;
import com.ceiba.gestionparqueadero.infraestructura.persistencia.builder.FacturaBuilder;
import com.ceiba.gestionparqueadero.infraestructura.persistencia.entity.FacturaEntity;

@Repository
public class RepositorioFacturaPersistente implements FacturaRepository{

	private EntityManager entityManager;
	
	public RepositorioFacturaPersistente(EntityManager entityManager){
		this.entityManager=entityManager;
	}

	@Override
	public FacturaResumen crearRegistro(FacturaResumen facturaPersist) {
		
		FacturaEntity facturaEntity=FacturaBuilder.convertirToFacturaEntity(facturaPersist);
		entityManager.persist(facturaEntity);
		entityManager.flush();	
		
		return new FacturaResumen(facturaEntity.getIdActividadEntity(), facturaPersist.getPlaca(),facturaEntity.getValorPagado());
	}
	
}
