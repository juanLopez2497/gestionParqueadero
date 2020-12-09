package com.ceiba.gestionParqueadero.infraestructura.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.gestionParqueadero.aplicacion.comando.ComandoGeneracionFactura;
import com.ceiba.gestionParqueadero.aplicacion.comando.ComandoRegistroParqueo;
import com.ceiba.gestionParqueadero.aplicacion.manejadores.actividad.ManejadorCrearActParqueo;
import com.ceiba.gestionParqueadero.aplicacion.manejadores.actividad.ManejedorObtenerActividades;
import com.ceiba.gestionParqueadero.aplicacion.manejadores.factura.ManejadorCrearFactura;
import com.ceiba.gestionParqueadero.dominio.ActividadResumen;
import com.ceiba.gestionParqueadero.dominio.FacturaResumen;

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
		return manejadorCrearActParqueo.CrearActividadParqueo(comandoRegistroParqueo);
	}
	@PostMapping("/generarFactura")
	public FacturaResumen GenerarFactura(@RequestBody ComandoGeneracionFactura comandoGeneracionFactura){
		return manejadorCrearFactura.crearFactura(comandoGeneracionFactura);
	}
	
	
}
