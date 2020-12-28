package com.ceiba.gestionparqueadero.dominio.excepcion;

public class TamanoExcedidoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5854080764105955686L;
	
	public TamanoExcedidoException(String message){
		super(message);
	}
}
