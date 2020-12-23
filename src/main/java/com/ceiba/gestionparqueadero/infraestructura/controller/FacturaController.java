package com.ceiba.gestionparqueadero.infraestructura.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.gestionparqueadero.aplicacion.comando.ComandoGeneracionFactura;
import com.ceiba.gestionparqueadero.aplicacion.manejadores.factura.ManejadorCrearFactura;
import com.ceiba.gestionparqueadero.dominio.dto.FacturaResumenDTO;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/factura")
public class FacturaController {
	private final ManejadorCrearFactura manejadorCrearFactura;
	public FacturaController(ManejadorCrearFactura manejadorCrearFactura){
		this.manejadorCrearFactura=manejadorCrearFactura;
	}
	
	@PostMapping("/facturaPersistente")
	public FacturaResumenDTO generarFactura(@RequestBody ComandoGeneracionFactura comandoGeneracionFactura){
		return manejadorCrearFactura.crearFactura(comandoGeneracionFactura);
	}
	
}
