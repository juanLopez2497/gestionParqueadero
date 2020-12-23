package com.ceiba.gestionparqueadero.testDataBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ceiba.gestionparqueadero.aplicacion.comando.ComandoRegistroParqueo;
import com.ceiba.gestionparqueadero.dominio.dto.ActividadResumenDTO;
import com.ceiba.gestionparqueadero.dominio.modelo.ActividadEjecutar;

public class ActividadTestDataBuilder {
	
	private static final Long ID_ACTIVIDAD=999L;
	private static final Long ID_ACTIVIDAD_DOM=996L;
	private static final LocalDateTime HORA_ENTRA_CADENA=LocalDateTime.of(2020, 12, 8, 21, 0, 0);
	private static final LocalDateTime DATA_TIME_ENTRA_DOMINGO=LocalDateTime.of(2020, 12, 6, 12, 0, 0);
	private static final String PLACA="WXZ09C";
	private static final String PLACA_DOMINGO="WXZ08C";
	private static final String ANOTACION="Entra con espejo IZQ roto";
	private static final String TIPO="M";
	private static final String TIPO_CARRO="C";
	private static final String PLACA_NUEVO="WXZ08C";
	private static final String ANOTACION_NUEVO="Entra con espejo roto";
	private static final String BONO="NO";
	private static final String BONO_SI="SI";
	
	private Long idActividad;
	private Long idActividadDom;
	private LocalDateTime horaEntraCadena;
	private LocalDateTime horaEntraDomingo;
	private String placa;
	private String anotacion;
	private String tipo;
	private String tipoCarro;
	private String placaNuevo;
	private String placaDom;
	private String anotacionNuevo;
	private String bono;
	private String tieneBono;
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
		this.bono=BONO;
		
		tipoCarro=TIPO_CARRO;
		tieneBono=BONO_SI;
	}
	
	public List<ActividadResumenDTO> listActividadesAutomotorActivas(){
		List<ActividadResumenDTO> lisActResumen = new ArrayList<>();
		ActividadResumenDTO actividad=new ActividadResumenDTO(this.horaEntraCadena, this.placa, this.anotacion, this.tipo, this.idActividad,this.bono);
		lisActResumen.add(actividad);
		return lisActResumen;
	}
	
	public List<ActividadResumenDTO> listActividadesAutomotorLimiteCupo(){
		List<ActividadResumenDTO> lisActResumen = new ArrayList<>();
		ActividadResumenDTO actividad=new ActividadResumenDTO(this.horaEntraCadena, this.placa, this.anotacion, this.tipo, this.idActividad,this.bono);
		for (int i = 0; i < 4; i++) {
			lisActResumen.add(actividad);
		}
		return lisActResumen;
	}
	
	public ActividadResumenDTO actividadCreada(){
		ActividadResumenDTO actividad=new ActividadResumenDTO(this.horaEntraCadena, this.placa, this.anotacion, this.tipo, this.idActividad,this.bono);
		return actividad;
	}
	
	public ActividadEjecutar generaActividadEjecutar(){
		ActividadEjecutar actividadEjecutar=new ActividadEjecutar(this.placa, this.anotacion, this.tipo,this.bono);
		return actividadEjecutar;
	}
	public ComandoRegistroParqueo creaActividad(){
		return new ComandoRegistroParqueo(placaNuevo, anotacionNuevo, tipo,this.bono);
	}
	public ActividadResumenDTO actividadCreadaInDomingo(){
		ActividadResumenDTO actividad=new ActividadResumenDTO(this.horaEntraDomingo, this.placaDom, this.anotacionNuevo, this.tipo, this.idActividadDom,this.bono);
		return actividad;
	}
	public ActividadResumenDTO actividadCreadaInDomingoBono(){
		ActividadResumenDTO actividad=new ActividadResumenDTO(this.horaEntraDomingo, this.placaDom, this.anotacionNuevo, this.tipoCarro, this.idActividadDom,this.tieneBono);
		return actividad;
	}
	public ComandoRegistroParqueo creaActividadFail(){
		return new ComandoRegistroParqueo(null, anotacionNuevo, tipo,this.bono);
	}
}
