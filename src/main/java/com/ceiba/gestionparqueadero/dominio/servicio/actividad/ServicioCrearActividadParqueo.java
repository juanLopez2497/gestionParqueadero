package com.ceiba.gestionparqueadero.dominio.servicio.actividad;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.gestionparqueadero.dominio.ActividadEjecutar;
import com.ceiba.gestionparqueadero.dominio.ActividadResumen;
import com.ceiba.gestionparqueadero.dominio.excepcion.ParqueaderoLlenoException;
import com.ceiba.gestionparqueadero.dominio.repositorio.ActividadRepository;

@Component
public class ServicioCrearActividadParqueo {
	
	private final ActividadRepository actividadRepository;
	
	private static final int MAXIMO_CUPOS_PLAZAS_PARQUEO=5;
	private static final String PARQUEADERO_LLENO_MSG="Parqueadero sin cupos disponibles, Gracias por prefereirnos, vualva más tarde";
	
	
	public ServicioCrearActividadParqueo(ActividadRepository actividadRepository){
		this.actividadRepository=actividadRepository;
	}
	
	public ActividadResumen crearActividadParqueo(ActividadEjecutar actividadEjecutar){
		
		List<ActividadResumen> listActivos=actividadRepository.listActivas();
		if(listActivos!=null && listActivos.size()<MAXIMO_CUPOS_PLAZAS_PARQUEO){
			return actividadRepository.agregar(actividadEjecutar);
		}else{
			throw new ParqueaderoLlenoException(PARQUEADERO_LLENO_MSG);
		}
	}
	
}
