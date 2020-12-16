package com.ceiba.gestionparqueadero.dominio;

import com.ceiba.gestionparqueadero.dominio.excepcion.CampoRequeridoException;

public class ValidadorCampos {
	
	private ValidadorCampos(){		
	}
	
	public static void validarNonNull(Object objeto, String errorMessage){
		if(objeto == null){
			throw new CampoRequeridoException(errorMessage);
		}
	}

}
