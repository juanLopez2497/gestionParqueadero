package com.ceiba.gestionparqueadero.testDataBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ceiba.gestionparqueadero.aplicacion.comando.ComandoRegistroParqueo;
import com.ceiba.gestionparqueadero.dominio.ActividadEjecutar;
import com.ceiba.gestionparqueadero.dominio.ActividadResumen;

public class ActividadTestDataBuilder {
	
	private static final Long ID_ACTIVIDAD=999L;
	private static final Long ID_ACTIVIDAD_DOM=996L;
	private static final LocalDateTime HORA_ENTRA_CADENA=LocalDateTime.of(2020, 12, 8, 21, 0, 0);
	private static final LocalDateTime DATA_TIME_ENTRA_DOMINGO=LocalDateTime.of(2020, 12, 6, 12, 0, 0);
	private static final String PLACA="WXZ09C";
	private static final String PLACA_DOMINGO="WXZ08C";
	private static final String ANOTACION="Entra con espejo IZQ roto";
	private static final String TIPO="M";
	private static final String PLACA_NUEVO="WXZ08C";
	private static final String ANOTACION_NUEVO="Entra con espejo roto";
	
	private Long idActividad;
	private Long idActividadDom;
	private LocalDateTime horaEntraCadena;
	private LocalDateTime horaEntraDomingo;
	private String placa;
	private String anotacion;
	private String tipo;
	private String placaNuevo;
	private String placaDom;
	private String anotacionNuevo;

	
	public ActividadTestDataBuilder(){
		this.idActividad=ID_ACTIVIDAD;
		this.horaEntraCadena=HORA_ENTRA_CADENA;
		
		this.placa=PLACA;
		this.anotacion=ANOTACION;
		this.tipo=TIPO;
		
		this.placaNuevo=PLACA_NUEVO;
		this.anotacionNuevo=ANOTACION_NUEVO;
		
		this.horaEntraDomingo=DATA_TIME_ENTRA_DOMINGO;
		this.placaDom=PLACA_DOMINGO;
		this.idActividadDom=ID_ACTIVIDAD_DOM;
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
	public ActividadResumen actividadCreadaInDomingo(){
		ActividadResumen actividad=new ActividadResumen(this.horaEntraDomingo, this.placaDom, this.anotacionNuevo, this.tipo, this.idActividadDom);
		return actividad;
	}

}
