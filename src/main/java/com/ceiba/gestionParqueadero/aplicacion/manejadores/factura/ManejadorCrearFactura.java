package com.ceiba.gestionParqueadero.aplicacion.manejadores.factura;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ceiba.gestionParqueadero.aplicacion.comando.ComandoGeneracionFactura;
import com.ceiba.gestionParqueadero.aplicacion.fabrica.FabricaGeneracionFactura;
import com.ceiba.gestionParqueadero.dominio.FacturaInicializar;
import com.ceiba.gestionParqueadero.dominio.FacturaResumen;
import com.ceiba.gestionParqueadero.dominio.servicio.factura.ServicioCrearFactura;

@Component
public class ManejadorCrearFactura {
	
	private final ServicioCrearFactura servicioCrearFactura;
	private final FabricaGeneracionFactura fabGenFactura;
	
	public ManejadorCrearFactura(ServicioCrearFactura servicioCrearFactura, FabricaGeneracionFactura fabGenFactura){
		this.servicioCrearFactura=servicioCrearFactura;
		this.fabGenFactura=fabGenFactura;
	}
	
	@Transactional
	public FacturaResumen crearFactura(ComandoGeneracionFactura comandoGeneracionFactura){
		FacturaInicializar facturaIni=fabGenFactura.recibirFacturaInicializar(comandoGeneracionFactura);
		return servicioCrearFactura.crearFactura(facturaIni);
	}
}
