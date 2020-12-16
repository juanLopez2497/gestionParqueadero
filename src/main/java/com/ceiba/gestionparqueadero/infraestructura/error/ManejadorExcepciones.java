package com.ceiba.gestionparqueadero.infraestructura.error;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ceiba.gestionparqueadero.dominio.excepcion.ActividadNoEncontrada;
import com.ceiba.gestionparqueadero.dominio.excepcion.CampoRequeridoException;
import com.ceiba.gestionparqueadero.dominio.excepcion.ParqueaderoLlenoException;

@ControllerAdvice
public class ManejadorExcepciones {
	
	private static final String ERROR_INESPERADO_CONTACTAR_ADMIN="Error inesperado servicio gestionParqueadero, contacta al admin";
	private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO= new ConcurrentHashMap<>();
	
	public ManejadorExcepciones(){
		CODIGOS_ESTADO.put(ParqueaderoLlenoException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		CODIGOS_ESTADO.put(ActividadNoEncontrada.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		CODIGOS_ESTADO.put(CampoRequeridoException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
	}
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Error> handleAllException(Exception exception){
		ResponseEntity<Error> resultado;
		
		String excepcionNombre=exception.getClass().getSimpleName();
		String mensaje=exception.getMessage();
		Integer codigo=CODIGOS_ESTADO.get(excepcionNombre);
		
		if(codigo!=null){
			Error error=new Error(excepcionNombre, mensaje);
			resultado=new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
		}else{
			Error error=new Error(excepcionNombre, ERROR_INESPERADO_CONTACTAR_ADMIN);
			resultado=new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resultado;
	}
}
