package com.ceiba.gestionParqueadero.dominio.servicio.actividad;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.gestionParqueadero.dominio.ActividadEjecutar;
import com.ceiba.gestionParqueadero.dominio.ActividadResumen;
import com.ceiba.gestionParqueadero.dominio.excepcion.ParqueaderoLlenoException;
import com.ceiba.gestionParqueadero.dominio.repositorio.IActividadRepository;

@Component
public class ServicioCrearActividadParqueo {
	
	private final IActividadRepository actividadRepository;
	
	private static final int MAXIMO_CUPOS_PLAZAS_PARQUEO=5;
	private static final String PARQUEADERO_LLENO_MSG="Parqueadero sin cupos disponibles, Gracias por prefereirnos, vualva más tarde";
	
	
	public ServicioCrearActividadParqueo(IActividadRepository actividadRepository){
		this.actividadRepository=actividadRepository;
	}
	
	public ActividadResumen CrearActividadParqueo(ActividadEjecutar actividadEjecutar){
		
		List<ActividadResumen> listActivos=actividadRepository.listActividadesActivas();
		if(listActivos!=null && listActivos.size()<MAXIMO_CUPOS_PLAZAS_PARQUEO){
			return actividadRepository.agregarActividad(actividadEjecutar);
		}else{
			throw new ParqueaderoLlenoException(PARQUEADERO_LLENO_MSG);
		}
		
	}
	
}
