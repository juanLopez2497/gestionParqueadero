package com.ceiba.gestionParqueadero.dominio.servicio.actividad;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.gestionParqueadero.dominio.ActividadResumen;
import com.ceiba.gestionParqueadero.dominio.excepcion.ParqueaderoVacioException;
import com.ceiba.gestionParqueadero.dominio.repositorio.IActividadRepository;

@Component
public class ServicioObtenerActividadAutomotor {
	
	private final String PARQUEADERO_VACIO="No hay resultados activos, parqueadero vacio. Intenta más tarde";
	
	private final IActividadRepository actividadRepository;
	
	public ServicioObtenerActividadAutomotor(IActividadRepository actividadRepository){
		this.actividadRepository=actividadRepository;
	}
	
	public List<ActividadResumen> listActividadesAutomotorActivas(){
		try{
			return actividadRepository.listActividadesActivas();
		} catch(Exception e){
			throw new ParqueaderoVacioException(PARQUEADERO_VACIO);
		}
	}
}
