package com.ceiba.gestionParqueadero.infraestructura.persistencia.repositorio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ceiba.gestionParqueadero.dominio.ActividadEjecutar;
import com.ceiba.gestionParqueadero.dominio.ActividadResumen;
import com.ceiba.gestionParqueadero.dominio.excepcion.ActividadNoEncontrada;
import com.ceiba.gestionParqueadero.dominio.repositorio.IActividadRepository;
import com.ceiba.gestionParqueadero.infraestructura.persistencia.builder.ActividadBuilder;
import com.ceiba.gestionParqueadero.infraestructura.persistencia.entity.ActividadEntity;

@Repository
public class RepositorioActividadPersistente implements IActividadRepository {
	
	private static final String ACTIVIDAD_NO_ENCONTRADA="id de Actividad no encontrado";
	
	private static final String BUSCA_REGISTROS_ACTIVOS = "Actividades.byEstado";
	private static final String BUSCA_ACTIVIDAD_POR_ID = "Actividades.byId";
	
	private EntityManager entityManager;
	
	public RepositorioActividadPersistente(EntityManager entityManager){
		this.entityManager=entityManager;
	}
	

	@Override
	public ActividadResumen agregarActividad(ActividadEjecutar actividad) {
		ActividadEntity actividadEntity=ActividadBuilder.convActividadEjecutarToEntity(actividad);
		
		entityManager.persist(actividadEntity);
		entityManager.flush();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String fechaCast=dateFormat.format(actividadEntity.getHoraEntra());
		
		return new ActividadResumen(fechaCast, actividadEntity.getRegistroAutomotorEntity().getPlaca(),
				actividadEntity.getRegistroAutomotorEntity().getAnotacion(), actividadEntity.getRegistroAutomotorEntity().getTipo(),
				actividadEntity.getId());	
	}

	@Override
	public List<ActividadResumen> listActividadesActivas() {
		List<ActividadResumen> listActividadDTO= new ArrayList<>();
		Query queryListActividadesAct=entityManager.createNamedQuery(BUSCA_REGISTROS_ACTIVOS);
		
		List<ActividadEntity> listActActivas=queryListActividadesAct.getResultList();
		for (ActividadEntity actividadEntity : listActActivas) {
			listActividadDTO.add(ActividadBuilder.convertirToActividadDTO(actividadEntity));
		}	
			
		return listActividadDTO;
	}


	@Override
	public ActividadResumen buscarActividadById(Long id) {
		ActividadEntity actividadEntity=new ActividadEntity();
		try {
			Query query=entityManager.createNamedQuery(BUSCA_ACTIVIDAD_POR_ID);
			query.setParameter("id",id);
			actividadEntity=(ActividadEntity) query.getSingleResult();
		} catch (Exception e) {
			throw new ActividadNoEncontrada(ACTIVIDAD_NO_ENCONTRADA);
		}
		return ActividadBuilder.convertirToActividadDTO(actividadEntity);
	}

}
