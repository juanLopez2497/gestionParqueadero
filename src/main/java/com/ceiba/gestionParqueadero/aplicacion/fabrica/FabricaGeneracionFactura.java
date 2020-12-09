package com.ceiba.gestionParqueadero.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.gestionParqueadero.aplicacion.comando.ComandoGeneracionFactura;
import com.ceiba.gestionParqueadero.dominio.FacturaInicializar;

@Component
public class FabricaGeneracionFactura {
	
	public FacturaInicializar recibirFacturaInicializar(ComandoGeneracionFactura ComandoGeneracionFactura){
		return new FacturaInicializar(ComandoGeneracionFactura.getId(),
				ComandoGeneracionFactura.getPlaca(), ComandoGeneracionFactura.getFlagBonoDescuento());
	}
	
}
