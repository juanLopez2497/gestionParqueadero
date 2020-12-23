package com.ceiba.gestionparqueadero.infraestructura.persistencia.repositorio;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.ceiba.gestionparqueadero.dominio.dto.FacturaResumenDTO;
import com.ceiba.gestionparqueadero.dominio.repositorio.FacturaRepository;
import com.ceiba.gestionparqueadero.infraestructura.persistencia.builder.FacturaBuilder;
import com.ceiba.gestionparqueadero.infraestructura.persistencia.entity.ActividadEntity;
import com.ceiba.gestionparqueadero.infraestructura.persistencia.entity.FacturaEntity;

@Repository
public class RepositorioFacturaPersistente implements FacturaRepository{

	private EntityManager entityManager;
	
	public RepositorioFacturaPersistente(EntityManager entityManager){
		this.entityManager=entityManager;
	}

	@Override
	public FacturaResumenDTO crearRegistro(FacturaResumenDTO facturaPersist) {
		
		FacturaEntity facturaEntity=FacturaBuilder.convertirToFacturaEntity(facturaPersist);
		entityManager.persist(facturaEntity);
		entityManager.flush();
		actualizaActividadPagada(facturaEntity.getIdActividadEntity());
		
		return new FacturaResumenDTO(facturaEntity.getIdActividadEntity(), facturaPersist.getPlaca(),facturaEntity.getValorPagado());
	}
	
	public void actualizaActividadPagada(Long id){
		ActividadEntity actividadToUpdate= entityManager.find(ActividadEntity.class, id);
		actividadToUpdate.setEstado("I");
		entityManager.merge(actividadToUpdate);
	}
	
}
