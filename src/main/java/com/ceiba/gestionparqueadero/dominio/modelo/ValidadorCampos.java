package com.ceiba.gestionparqueadero.dominio.modelo;

import com.ceiba.gestionparqueadero.dominio.excepcion.CampoRequeridoException;
import com.ceiba.gestionparqueadero.dominio.excepcion.RespBonoIncorrectoException;
import com.ceiba.gestionparqueadero.dominio.excepcion.TamanoExcedidoException;
import com.ceiba.gestionparqueadero.dominio.excepcion.TipoAutoIncorrectoException;

public final class ValidadorCampos {
	
	private static final String MOTO="M";
	private static final String CARRO="C";
	private static final String TIENE_BONO="SI";
	private static final String NO_BONO="NO";
	
	private ValidadorCampos(){		
	}
	
	public static void validarNonNull(Object objeto, String errorMessage){
		if(objeto == null){
			throw new CampoRequeridoException(errorMessage);
		}
	}
	
	public static void validaMaxCaracteres(String cadenaIn, String errorMessage, Long cantidad){
		if(cadenaIn.length()>cantidad){
			throw new TamanoExcedidoException(errorMessage);
		}
	}
	public static void validaFormatoTipoAut(String cadenaIn, String errorMessage){
		if(!cadenaIn.equals(MOTO) && !cadenaIn.equals(CARRO)){
			throw new TipoAutoIncorrectoException(errorMessage);
		}
	}
	public static void validarRespBono(String cadenaIn, String errorMessage){
		if(!cadenaIn.equals(TIENE_BONO) && !cadenaIn.equals(NO_BONO)){
			throw new RespBonoIncorrectoException(errorMessage);
		}
	}
}
