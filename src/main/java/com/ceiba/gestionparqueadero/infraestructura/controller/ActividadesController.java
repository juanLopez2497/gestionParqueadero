package com.ceiba.gestionparqueadero.infraestructura.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.gestionparqueadero.aplicacion.comando.ComandoRegistroParqueo;
import com.ceiba.gestionparqueadero.aplicacion.manejadores.actividad.ManejadorCrearActParqueo;
import com.ceiba.gestionparqueadero.aplicacion.manejadores.actividad.ManejedorObtenerActividades;
import com.ceiba.gestionparqueadero.dominio.dto.ActividadResumenDTO;


@RestController
@RequestMapping("/registros")
public class ActividadesController {
	private final ManejedorObtenerActividades manejedorObtenerActividades;
	private final ManejadorCrearActParqueo manejadorCrearActParqueo;
	
	
	public ActividadesController(ManejedorObtenerActividades manejedorObtenerActividades,
			ManejadorCrearActParqueo manejadorCrearActParqueo){
		this.manejedorObtenerActividades=manejedorObtenerActividades;
		this.manejadorCrearActParqueo=manejadorCrearActParqueo;
	}
	
	@GetMapping("/historicos")
	public List<ActividadResumenDTO> getListActividades(){
		return manejedorObtenerActividades.listActividadesAutomotorActivas();
	}
	@PostMapping("/actividades")
	public ActividadResumenDTO agregaRegistroActividad(@RequestBody ComandoRegistroParqueo comandoRegistroParqueo){
		return manejadorCrearActParqueo.crearActividadParqueo(comandoRegistroParqueo);
	}
}
