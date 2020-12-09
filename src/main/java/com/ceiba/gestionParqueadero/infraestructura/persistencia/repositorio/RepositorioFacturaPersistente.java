package com.ceiba.gestionParqueadero.infraestructura.persistencia.repositorio;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.ceiba.gestionParqueadero.dominio.FacturaResumen;
import com.ceiba.gestionParqueadero.dominio.repositorio.IFactura;
import com.ceiba.gestionParqueadero.infraestructura.persistencia.builder.FacturaBuilder;
import com.ceiba.gestionParqueadero.infraestructura.persistencia.entity.FacturaEntity;

@Repository
public class RepositorioFacturaPersistente implements IFactura{

	private EntityManager entityManager;
	
	public RepositorioFacturaPersistente(EntityManager entityManager){
		this.entityManager=entityManager;
	}

	@Override
	public FacturaResumen crearFacturaRegistro(FacturaResumen facturaPersist) {
		
		FacturaEntity facturaEntity=FacturaBuilder.convertirToFacturaEntity(facturaPersist);
		entityManager.persist(facturaEntity);
		entityManager.flush();	
		
		return new FacturaResumen(facturaEntity.getIdActividadEntity(), facturaPersist.getPlaca(),facturaEntity.getValorPagado());
	}
	
}
