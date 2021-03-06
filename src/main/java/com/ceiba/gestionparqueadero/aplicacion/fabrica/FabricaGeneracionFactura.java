package com.ceiba.gestionparqueadero.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.gestionparqueadero.aplicacion.comando.ComandoGeneracionFactura;
import com.ceiba.gestionparqueadero.dominio.modelo.FacturaInicializar;

@Component
public class FabricaGeneracionFactura {
	
	public FacturaInicializar recibirFacturaInicializar(ComandoGeneracionFactura comandoGeneracionFactura){
		return new FacturaInicializar(comandoGeneracionFactura.getId());
	}
	
}
