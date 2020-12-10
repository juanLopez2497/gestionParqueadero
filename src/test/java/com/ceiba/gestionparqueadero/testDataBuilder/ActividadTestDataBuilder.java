package com.ceiba.gestionparqueadero.testDataBuilder;

import java.util.ArrayList;
import java.util.List;

import com.ceiba.gestionparqueadero.aplicacion.comando.ComandoRegistroParqueo;
import com.ceiba.gestionparqueadero.dominio.ActividadEjecutar;
import com.ceiba.gestionparqueadero.dominio.ActividadResumen;

public class ActividadTestDataBuilder {
	private static final Long ID_ACTIVIDAD=999L;

	private static final String HORA_ENTRA_CADENA="2020-12-08 21:00:00";
	
	private static final String PLACA="WXZ09C";
	private static final String ANOTACION="Entra con espejo IZQ roto";
	private static final String TIPO="M";
	
	private static final String PLACA_NUEVO="WXZ08C";
	private static final String ANOTACION_NUEVO="Entra con espejo derecho roto";
	
	private Long idActividad;
	private String horaEntraCadena;
	private String placa;
	private String anotacion;
	private String tipo;
	private String placaNuevo;
	private String anotacionNuevo;

	
	public ActividadTestDataBuilder(){
		this.idActividad=ID_ACTIVIDAD;
		this.horaEntraCadena=HORA_ENTRA_CADENA;
		
		this.placa=PLACA;
		this.anotacion=ANOTACION;
		this.tipo=TIPO;
		
		this.placaNuevo=PLACA_NUEVO;
		this.anotacionNuevo=ANOTACION_NUEVO;
	}
	
	public List<ActividadResumen> listActividadesAutomotorActivas(){
		List<ActividadResumen> lisActResumen = new ArrayList<>();
		ActividadResumen actividad=new ActividadResumen(this.horaEntraCadena, this.placa, this.anotacion, this.tipo, this.idActividad);
		lisActResumen.add(actividad);
		return lisActResumen;
	}
	
	public ActividadResumen actividadCreada(){
		ActividadResumen actividad=new ActividadResumen(this.horaEntraCadena, this.placa, this.anotacion, this.tipo, this.idActividad);
		return actividad;
	}
	
	public ActividadEjecutar generaActividadEjecutar(){
		ActividadEjecutar actividadEjecutar=new ActividadEjecutar(this.placa, this.anotacion, this.tipo);
		return actividadEjecutar;
	}
	public ComandoRegistroParqueo creaActividad(){
		return new ComandoRegistroParqueo(placaNuevo, anotacionNuevo, tipo);
	}
	

}
