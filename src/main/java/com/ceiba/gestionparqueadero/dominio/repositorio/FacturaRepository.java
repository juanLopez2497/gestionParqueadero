package com.ceiba.gestionparqueadero.dominio.repositorio;

import com.ceiba.gestionparqueadero.dominio.dto.FacturaResumenDTO;

public interface FacturaRepository {
	FacturaResumenDTO crearRegistro(FacturaResumenDTO facturaPersist);

}
