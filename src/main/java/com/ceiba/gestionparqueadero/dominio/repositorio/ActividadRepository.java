package com.ceiba.gestionparqueadero.dominio.repositorio;

import java.util.List;

import com.ceiba.gestionparqueadero.dominio.dto.ActividadResumenDTO;
import com.ceiba.gestionparqueadero.dominio.modelo.ActividadEjecutar;

public interface ActividadRepository {
	
	ActividadResumenDTO agregar(ActividadEjecutar actividad);
	
	List<ActividadResumenDTO> listActivas();
	
	ActividadResumenDTO buscarById(Long id);

}
