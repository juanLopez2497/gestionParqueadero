package com.ceiba.gestionparqueadero.aplicacion.manejadores.actividad;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ceiba.gestionparqueadero.aplicacion.comando.ComandoRegistroParqueo;
import com.ceiba.gestionparqueadero.aplicacion.fabrica.FabricaAcividadParqueadero;
import com.ceiba.gestionparqueadero.dominio.dto.ActividadResumenDTO;
import com.ceiba.gestionparqueadero.dominio.modelo.ActividadEjecutar;
import com.ceiba.gestionparqueadero.dominio.servicio.actividad.ServicioCrearActividadParqueo;

@Component
public class ManejadorCrearActParqueo {
	 
	private final ServicioCrearActividadParqueo servicioCrearActividadParqueo;
	private final FabricaAcividadParqueadero fabricaAcividadParqueadero;
	
	public ManejadorCrearActParqueo(ServicioCrearActividadParqueo servicioCrearActividadParqueo,
			FabricaAcividadParqueadero fabricaAcividadParqueadero){
		this.servicioCrearActividadParqueo=servicioCrearActividadParqueo;
		this.fabricaAcividadParqueadero=fabricaAcividadParqueadero;
	}
	
	@Transactional
	public ActividadResumenDTO crearActividadParqueo(ComandoRegistroParqueo comandoRegistroParqueo){
		ActividadEjecutar actividadEjecutar=fabricaAcividadParqueadero.crearActividadEjecutar(comandoRegistroParqueo);
		return servicioCrearActividadParqueo.crearActividadParqueo(actividadEjecutar); 
	}
}
