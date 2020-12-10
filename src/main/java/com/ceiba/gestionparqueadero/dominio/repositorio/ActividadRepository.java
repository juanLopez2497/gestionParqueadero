package com.ceiba.gestionparqueadero.dominio.repositorio;

import java.util.List;

import com.ceiba.gestionparqueadero.dominio.ActividadEjecutar;
import com.ceiba.gestionparqueadero.dominio.ActividadResumen;

public interface ActividadRepository {
	
	ActividadResumen agregar(ActividadEjecutar actividad);
	
	List<ActividadResumen> listActivas();
	
	ActividadResumen buscarById(Long id);

}
