package com.ceiba.gestionparqueadero.infraestructura.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.gestionparqueadero.aplicacion.comando.ComandoGeneracionFactura;
import com.ceiba.gestionparqueadero.aplicacion.comando.ComandoRegistroParqueo;
import com.ceiba.gestionparqueadero.aplicacion.manejadores.actividad.ManejadorCrearActParqueo;
import com.ceiba.gestionparqueadero.aplicacion.manejadores.actividad.ManejedorObtenerActividades;
import com.ceiba.gestionparqueadero.aplicacion.manejadores.factura.ManejadorCrearFactura;
import com.ceiba.gestionparqueadero.dominio.ActividadResumen;
import com.ceiba.gestionparqueadero.dominio.FacturaResumen;

@RestController
@RequestMapping("/actividades")
public class ActividadesController {
	private final ManejedorObtenerActividades manejedorObtenerActividades;
	private final ManejadorCrearActParqueo manejadorCrearActParqueo;
	
	private final ManejadorCrearFactura manejadorCrearFactura;
	
	public ActividadesController(ManejedorObtenerActividades manejedorObtenerActividades,
			ManejadorCrearActParqueo manejadorCrearActParqueo, ManejadorCrearFactura manejadorCrearFactura){
		this.manejedorObtenerActividades=manejedorObtenerActividades;
		this.manejadorCrearActParqueo=manejadorCrearActParqueo;
		this.manejadorCrearFactura=manejadorCrearFactura;
	}
	
	@GetMapping("/obtenerListaActividadesActivas")
	public List<ActividadResumen> getListActividades(){
		return manejedorObtenerActividades.listActividadesAutomotorActivas();
	}
	@PostMapping("/agregar")
	public ActividadResumen agregaRegistroActividad(@RequestBody ComandoRegistroParqueo comandoRegistroParqueo){
		return manejadorCrearActParqueo.crearActividadParqueo(comandoRegistroParqueo);
	}
	@PostMapping("/generarFactura")
	public FacturaResumen GenerarFactura(@RequestBody ComandoGeneracionFactura comandoGeneracionFactura){
		return manejadorCrearFactura.crearFactura(comandoGeneracionFactura);
	}
	
	
}
