package com.ceiba.gestionparqueadero.dominio.excepcion;

public class CampoRequeridoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2425898890398014729L;

	public CampoRequeridoException(String mensaje){
		super(mensaje);
	}
}
