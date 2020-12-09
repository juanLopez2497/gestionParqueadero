package com.ceiba.gestionParqueadero.dominio.repositorio;

import java.util.List;

import com.ceiba.gestionParqueadero.dominio.Actividad;
import com.ceiba.gestionParqueadero.dominio.ActividadEjecutar;
import com.ceiba.gestionParqueadero.dominio.ActividadResumen;

public interface IActividadRepository {
	
	ActividadResumen agregarActividad(ActividadEjecutar actividad);
	
	List<ActividadResumen> listActividadesActivas();
	
	ActividadResumen buscarActividadById(Long id);

}
