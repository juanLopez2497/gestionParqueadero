package com.ceiba.gestionparqueadero.dominio.servicio.actividad;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.gestionparqueadero.dominio.dto.ActividadResumenDTO;
import com.ceiba.gestionparqueadero.dominio.excepcion.ParqueaderoLlenoException;
import com.ceiba.gestionparqueadero.dominio.modelo.ActividadEjecutar;
import com.ceiba.gestionparqueadero.dominio.repositorio.ActividadRepository;

@Component
public class ServicioCrearActividadParqueo {
	
	private final ActividadRepository actividadRepository;
	
	private static final Long MAXIMO_CUPOS_PLAZAS_PARQUEO=10000000000L;
	private static final String PARQUEADERO_LLENO_MSG="Parqueadero sin cupos disponibles, Gracias por prefereirnos, vualva más tarde";
	
	
	public ServicioCrearActividadParqueo(ActividadRepository actividadRepository){
		this.actividadRepository=actividadRepository;
	}
	
	public ActividadResumenDTO crearActividadParqueo(ActividadEjecutar actividadEjecutar){
		boolean tieneCupo=validarCupoParqueadero(MAXIMO_CUPOS_PLAZAS_PARQUEO);
		ActividadResumenDTO actividadResumenDTO=null;
		if(tieneCupo){
			actividadResumenDTO=actividadRepository.agregar(actividadEjecutar);
		}
		return actividadResumenDTO;
	}
	
	public boolean validarCupoParqueadero(Long maxNumCupos){
		List<ActividadResumenDTO> listActivos=actividadRepository.listActivas();
		boolean result=false;
		if(listActivos!=null && listActivos.size()<maxNumCupos){
			result=true;
		}else{
			throw new ParqueaderoLlenoException(PARQUEADERO_LLENO_MSG);
		}
		return result;
	}
	
}
