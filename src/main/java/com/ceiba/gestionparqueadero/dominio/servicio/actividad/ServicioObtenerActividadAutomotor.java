package com.ceiba.gestionparqueadero.dominio.servicio.actividad;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.ceiba.gestionparqueadero.dominio.ActividadResumen;
import com.ceiba.gestionparqueadero.dominio.excepcion.ParqueaderoVacioException;
import com.ceiba.gestionparqueadero.dominio.repositorio.ActividadRepository;

@Component
public class ServicioObtenerActividadAutomotor {
	
	private static final String PARQUEADERO_VACIO="No hay resultados activos, parqueadero vacio. Intenta más tarde";
	
	private final ActividadRepository actividadRepository;
	
	private static final Logger LOG=LogManager.getLogger(ServicioObtenerActividadAutomotor.class);
	
	public ServicioObtenerActividadAutomotor(ActividadRepository actividadRepository){
		this.actividadRepository=actividadRepository;
	}
	
	public List<ActividadResumen> listActividadesAutomotorActivas(){
		try{
			return actividadRepository.listActivas();
		} catch(Exception e){
			LOG.info(e.getMessage());
			throw new ParqueaderoVacioException(PARQUEADERO_VACIO);
		}
	}
}
