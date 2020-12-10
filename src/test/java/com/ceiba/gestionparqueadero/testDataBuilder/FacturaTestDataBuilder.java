package com.ceiba.gestionparqueadero.testDataBuilder;

import com.ceiba.gestionparqueadero.aplicacion.comando.ComandoGeneracionFactura;

public class FacturaTestDataBuilder {
	
	private static final Long ID_REG_ACTIVIDAD=999L;
	private static final Long ID_REG_ACTIVIDAD_NO_EXISTE=10L;
	private static final String FLAG_BONO_DESCUENTO="N";
	private static final String PLACA="WXZ09C";
	
	private Long idRegActividad;
	private Long idRegActividadNoExiste;
	private String flagBono;
	private String placa;

	
	public FacturaTestDataBuilder(){
		this.idRegActividad=ID_REG_ACTIVIDAD;
		this.flagBono=FLAG_BONO_DESCUENTO;
		this.placa=PLACA;
		this.idRegActividadNoExiste=ID_REG_ACTIVIDAD_NO_EXISTE;
	}
	
	public ComandoGeneracionFactura inicializaFactura(){
		return new ComandoGeneracionFactura(idRegActividad, placa, flagBono);
	}
	public ComandoGeneracionFactura inicializaFacturaFail(){
		return new ComandoGeneracionFactura(idRegActividadNoExiste, placa, flagBono);
	}
	
}
