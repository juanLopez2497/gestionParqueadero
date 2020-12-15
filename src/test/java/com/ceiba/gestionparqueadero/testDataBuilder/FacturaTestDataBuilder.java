package com.ceiba.gestionparqueadero.testDataBuilder;

import java.time.LocalDateTime;

import com.ceiba.gestionparqueadero.aplicacion.comando.ComandoGeneracionFactura;
import com.ceiba.gestionparqueadero.dominio.FacturaInicializar;
import com.ceiba.gestionparqueadero.dominio.FacturaResumen;

public class FacturaTestDataBuilder {
	
	private static final Long ID_REG_ACTIVIDAD=999L;
	private static final Long ID_REG_ACTIVIDAD_DOM=996L;
	private static final Long ID_REG_ACTIVIDAD_NO_EXISTE=10L;
	private static final String FLAG_BONO_DESCUENTO="N";
	private static final String PLACA="WXZ09C";
	private static final String PLACA_DOM="WXZ08C";
	private static final LocalDateTime DATE_TIME_SALE_DOMINGO=LocalDateTime.of(2020, 12, 6, 12, 45, 0);
	private static final double COSTO_TEST_DOMIGO=1050;
	
	private Long idRegActividad;
	private Long idRegActividadDom;
	private Long idRegActividadNoExiste;
	private String flagBono;
	private String placa;
	private String placaDom;
	private LocalDateTime horaSaleDomingo;
	private double costoDomingo;
	
	public FacturaTestDataBuilder(){
		this.idRegActividad=ID_REG_ACTIVIDAD;
		this.flagBono=FLAG_BONO_DESCUENTO;
		this.placa=PLACA;
		this.idRegActividadNoExiste=ID_REG_ACTIVIDAD_NO_EXISTE;
		this.horaSaleDomingo=DATE_TIME_SALE_DOMINGO;
		this.costoDomingo=COSTO_TEST_DOMIGO;
		this.idRegActividadDom=ID_REG_ACTIVIDAD_DOM;
		this.placaDom=PLACA_DOM;
	}
	
	public ComandoGeneracionFactura inicializaFactura(){
		return new ComandoGeneracionFactura(idRegActividad, placa, flagBono);
	}
	public ComandoGeneracionFactura inicializaFacturaFail(){
		return new ComandoGeneracionFactura(idRegActividadNoExiste, placa, flagBono);
	}
	public FacturaInicializar inicFacturaDomingo(){
		return new FacturaInicializar(idRegActividadDom, placaDom, flagBono,horaSaleDomingo);
	}
	public FacturaResumen inicFacturaResumenDomingo(){
		return new FacturaResumen(idRegActividadDom, placaDom, costoDomingo);
	}
}
