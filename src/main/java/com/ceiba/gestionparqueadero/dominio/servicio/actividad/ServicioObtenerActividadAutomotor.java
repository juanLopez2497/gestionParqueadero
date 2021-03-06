package com.ceiba.gestionparqueadero.dominio.servicio.actividad;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.gestionparqueadero.dominio.dto.ActividadResumenDTO;
import com.ceiba.gestionparqueadero.dominio.repositorio.ActividadRepository;

@Component
public class ServicioObtenerActividadAutomotor {
		
	private final ActividadRepository actividadRepository;
		
	public ServicioObtenerActividadAutomotor(ActividadRepository actividadRepository){
		this.actividadRepository=actividadRepository;
	}
	
	public List<ActividadResumenDTO> listActividadesAutomotorActivas(){
			return actividadRepository.listActivas();
	}
}
