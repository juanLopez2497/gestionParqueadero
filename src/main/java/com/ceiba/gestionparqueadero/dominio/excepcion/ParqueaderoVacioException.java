package com.ceiba.gestionparqueadero.dominio.excepcion;

public class ParqueaderoVacioException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6431653903689154250L;
	
	public ParqueaderoVacioException(String mensaje){
		super(mensaje);
	}
}
