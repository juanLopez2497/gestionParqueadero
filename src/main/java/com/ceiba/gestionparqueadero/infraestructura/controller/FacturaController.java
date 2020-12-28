package com.ceiba.gestionparqueadero.infraestructura.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.gestionparqueadero.aplicacion.comando.ComandoGeneracionFactura;
import com.ceiba.gestionparqueadero.aplicacion.manejadores.factura.ManejadorCrearFactura;
import com.ceiba.gestionparqueadero.dominio.dto.FacturaResumenDTO;

@RestController
@RequestMapping("/registros")
public class FacturaController {
	private final ManejadorCrearFactura manejadorCrearFactura;
	public FacturaController(ManejadorCrearFactura manejadorCrearFactura){
		this.manejadorCrearFactura=manejadorCrearFactura;
	}
	
	@PostMapping("/facturas")
	public FacturaResumenDTO generarFactura(@RequestBody ComandoGeneracionFactura comandoGeneracionFactura){
		return manejadorCrearFactura.crearFactura(comandoGeneracionFactura);
	}
	
}
