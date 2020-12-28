package com.ceiba.gestionparqueadero.dominio.excepcion;

public class TipoAutoIncorrectoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7350325844276665939L;
	
	public TipoAutoIncorrectoException(String message){
		super(message);
	}
}
