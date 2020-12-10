package com.ceiba.gestionparqueadero.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.gestionparqueadero.aplicacion.comando.ComandoRegistroParqueo;
import com.ceiba.gestionparqueadero.dominio.ActividadEjecutar;

@Component
public class FabricaAcividadParqueadero {
	
	public ActividadEjecutar crearActividadEjecutar(ComandoRegistroParqueo comandoRegistroParqueo){
		return new ActividadEjecutar(comandoRegistroParqueo.getPlaca(), comandoRegistroParqueo.getAnotacion(),
				comandoRegistroParqueo.getTipo());
	}
}
