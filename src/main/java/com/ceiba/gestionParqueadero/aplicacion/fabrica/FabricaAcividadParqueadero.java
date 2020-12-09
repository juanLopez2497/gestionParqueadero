package com.ceiba.gestionParqueadero.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.gestionParqueadero.aplicacion.comando.ComandoRegistroParqueo;
import com.ceiba.gestionParqueadero.dominio.ActividadEjecutar;

@Component
public class FabricaAcividadParqueadero {
	
	public ActividadEjecutar crearActividadEjecutar(ComandoRegistroParqueo comandoRegistroParqueo){
		return new ActividadEjecutar(comandoRegistroParqueo.getPlaca(), comandoRegistroParqueo.getAnotacion(),
				comandoRegistroParqueo.getTipo());
	}
}
