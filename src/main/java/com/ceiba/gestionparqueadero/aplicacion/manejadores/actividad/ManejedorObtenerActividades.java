package com.ceiba.gestionparqueadero.aplicacion.manejadores.actividad;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.gestionparqueadero.dominio.dto.ActividadResumenDTO;
import com.ceiba.gestionparqueadero.dominio.servicio.actividad.ServicioObtenerActividadAutomotor;

@Component
public class ManejedorObtenerActividades {
	
	private final ServicioObtenerActividadAutomotor servicioObtenerActividadAutomotor;
	
	public ManejedorObtenerActividades(ServicioObtenerActividadAutomotor servicioObtenerActividadAutomotor){
		this.servicioObtenerActividadAutomotor=servicioObtenerActividadAutomotor;
	}
	
	public List<ActividadResumenDTO> listActividadesAutomotorActivas(){
		return servicioObtenerActividadAutomotor.listActividadesAutomotorActivas();
	}

}
