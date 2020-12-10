package com.ceiba.gestionparqueadero.dominio.repositorio;

import com.ceiba.gestionparqueadero.dominio.FacturaResumen;

public interface FacturaRepository {
	FacturaResumen crearRegistro(FacturaResumen facturaPersist);

}
