package com.ceiba.gestionParqueadero.dominio.repositorio;

import com.ceiba.gestionParqueadero.dominio.FacturaResumen;

public interface IFactura {
	FacturaResumen crearFacturaRegistro(FacturaResumen facturaPersist);

}
