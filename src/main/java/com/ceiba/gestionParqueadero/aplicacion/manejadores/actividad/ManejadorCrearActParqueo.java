package com.ceiba.gestionParqueadero.aplicacion.manejadores.actividad;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ceiba.gestionParqueadero.aplicacion.comando.ComandoRegistroParqueo;
import com.ceiba.gestionParqueadero.aplicacion.fabrica.FabricaAcividadParqueadero;
import com.ceiba.gestionParqueadero.dominio.ActividadEjecutar;
import com.ceiba.gestionParqueadero.dominio.ActividadResumen;
import com.ceiba.gestionParqueadero.dominio.servicio.actividad.ServicioCrearActividadParqueo;

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
	public ActividadResumen CrearActividadParqueo(ComandoRegistroParqueo comandoRegistroParqueo){
		ActividadEjecutar actividadEjecutar=fabricaAcividadParqueadero.crearActividadEjecutar(comandoRegistroParqueo);
		return servicioCrearActividadParqueo.CrearActividadParqueo(actividadEjecutar); 
	}
}
