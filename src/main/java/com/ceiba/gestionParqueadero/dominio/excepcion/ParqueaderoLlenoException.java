package com.ceiba.gestionParqueadero.dominio.excepcion;

public class ParqueaderoLlenoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 47871122470733319L;

	public ParqueaderoLlenoException(String mensaje){
		super(mensaje);
	}
}
