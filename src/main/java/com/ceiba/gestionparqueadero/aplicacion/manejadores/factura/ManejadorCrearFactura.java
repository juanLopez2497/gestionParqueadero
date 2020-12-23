package com.ceiba.gestionparqueadero.aplicacion.manejadores.factura;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ceiba.gestionparqueadero.aplicacion.comando.ComandoGeneracionFactura;
import com.ceiba.gestionparqueadero.aplicacion.fabrica.FabricaGeneracionFactura;
import com.ceiba.gestionparqueadero.dominio.dto.FacturaResumenDTO;
import com.ceiba.gestionparqueadero.dominio.modelo.FacturaInicializar;
import com.ceiba.gestionparqueadero.dominio.servicio.factura.ServicioCrearFactura;

@Component
public class ManejadorCrearFactura {
	
	private final ServicioCrearFactura servicioCrearFactura;
	private final FabricaGeneracionFactura fabGenFactura;
	
	public ManejadorCrearFactura(ServicioCrearFactura servicioCrearFactura, FabricaGeneracionFactura fabGenFactura){
		this.servicioCrearFactura=servicioCrearFactura;
		this.fabGenFactura=fabGenFactura;
	}
	
	@Transactional
	public FacturaResumenDTO crearFactura(ComandoGeneracionFactura comandoGeneracionFactura){
		FacturaInicializar facturaIni=fabGenFactura.recibirFacturaInicializar(comandoGeneracionFactura);
		return servicioCrearFactura.crearFactura(facturaIni);
	}
}
