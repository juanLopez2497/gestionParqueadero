package com.ceiba.gestionparqueadero.dominio.modelo;

import java.time.LocalDateTime;

public class ActividadEjecutar {
	
	private static final String PLACA_OBLIGATORIO = "error, la placa obligatoria.";
	private static final String TPO_OBLIGATORIO = "error, el tipo es obligatorio.";
	private static final String BONO_OBLIGATORIO = "error, pregunta de bono obligatoria.";
	private static final String MAXIMO_LETRAS_PLACA = "Error, placa excede el maximo de carateres permitidos";
	private static final String MAXIMO_LETRAS_ANOTACION = "Error, anotación excede el maximo de carateres permitidos";
	private static final String TIPO_AUT_INCORRECTO = "Error, tipo de automotor desconocido o no registrado en el sistema";
	private static final String RESP_BONO_INCORRECTO = "Error, respuesta de bono desconocida o no registrada en el sistema";
	private static final Long MAX_CARACTERES_PLACA=6L;
	private static final Long MAX_CARACTERES_ANOTACION=200L;
	
	private String placa;
	private String anotacion;
	private LocalDateTime fechaEntra;
	private String tipo;
	private String bono;
	
	public ActividadEjecutar(String placa, String anotacion, String tipo, String bono){
		ValidadorCampos.validarNonNull(placa, PLACA_OBLIGATORIO);
		ValidadorCampos.validarNonNull(tipo, TPO_OBLIGATORIO);
		ValidadorCampos.validarNonNull(bono, BONO_OBLIGATORIO);
		ValidadorCampos.validaMaxCaracteres(placa, MAXIMO_LETRAS_PLACA, MAX_CARACTERES_PLACA);
		ValidadorCampos.validaMaxCaracteres(placa, MAXIMO_LETRAS_ANOTACION, MAX_CARACTERES_ANOTACION);
		ValidadorCampos.validaFormatoTipoAut(tipo, TIPO_AUT_INCORRECTO);
		ValidadorCampos.validarRespBono(bono, RESP_BONO_INCORRECTO);
		this.fechaEntra = LocalDateTime.now();
		this.anotacion=anotacion;
		this.placa=placa;
		this.tipo=tipo;
		this.bono=bono;
	}
	
	public String getPlaca() {
		return placa;
	}
	public String getAnotacion() {
		return anotacion;
	}
	public LocalDateTime getFechaEntra() {
		return fechaEntra;
	}
	public String getTipo() {
		return tipo;
	}
	public String getBono() {
		return bono;
	}
	
}
