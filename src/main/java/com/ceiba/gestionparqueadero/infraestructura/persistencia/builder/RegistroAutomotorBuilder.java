package com.ceiba.gestionparqueadero.infraestructura.persistencia.builder;

import com.ceiba.gestionparqueadero.dominio.RegistroAutomotor;
import com.ceiba.gestionparqueadero.infraestructura.persistencia.entity.RegistroAutomotorEntity;

public class RegistroAutomotorBuilder {
	private RegistroAutomotorBuilder(){
		
	}
	
	public static RegistroAutomotorEntity convertirToRegistroAutEntity(RegistroAutomotor registroAutomotor){
		RegistroAutomotorEntity regAutEntity=new RegistroAutomotorEntity();
		
		regAutEntity.setAnotacion(registroAutomotor.getAnotacion());
		regAutEntity.setPlaca(registroAutomotor.getPlaca());;
		regAutEntity.setTipo(registroAutomotor.getTipo());
		return regAutEntity;
	}

}
