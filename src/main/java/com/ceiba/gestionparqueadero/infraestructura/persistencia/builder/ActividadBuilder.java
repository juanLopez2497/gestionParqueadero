package com.ceiba.gestionparqueadero.infraestructura.persistencia.builder;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.ceiba.gestionparqueadero.dominio.dto.ActividadResumenDTO;
import com.ceiba.gestionparqueadero.dominio.modelo.ActividadEjecutar;
import com.ceiba.gestionparqueadero.infraestructura.persistencia.entity.ActividadEntity;
import com.ceiba.gestionparqueadero.infraestructura.persistencia.entity.RegistroAutomotorEntity;

public final class ActividadBuilder {
	
	private ActividadBuilder(){
		
	}
	
	public static ActividadResumenDTO convertirToActividadDTO(ActividadEntity actividadEntity){
		return new ActividadResumenDTO(convertDateToLocal(actividadEntity.getHoraEntra()), actividadEntity.getRegistroAutomotorEntity().getPlaca(),
				actividadEntity.getRegistroAutomotorEntity().getAnotacion(), actividadEntity.getRegistroAutomotorEntity().getTipo(),
				actividadEntity.getId(), actividadEntity.getBono());
	}
	
	public static ActividadEntity convActividadEjecutarToEntity(ActividadEjecutar actividadEjecutar){
		RegistroAutomotorEntity regAutomotor=new RegistroAutomotorEntity();
		ActividadEntity actividadEntity=new ActividadEntity();
		
		regAutomotor.setAnotacion(actividadEjecutar.getAnotacion());
		regAutomotor.setPlaca(actividadEjecutar.getPlaca());
		regAutomotor.setTipo(actividadEjecutar.getTipo());
		
		actividadEntity.setEstado("A");
		actividadEntity.setHoraEntra(convertLocalToDate(actividadEjecutar.getFechaEntra()));
		actividadEntity.setRegistroAutomotorEntity(regAutomotor);
		actividadEntity.setBono(actividadEjecutar.getBono());
		
		return actividadEntity;
	}
	public static Date convertLocalToDate(LocalDateTime toDate){
		Date dateConverted=null; 
		if(toDate!=null){
			dateConverted= Date.from(toDate.atZone(ZoneId.systemDefault()).toInstant());
		}
		return dateConverted;
	}
	
	public static  LocalDateTime convertDateToLocal(Date toLocal){
		LocalDateTime dateConverted=null;
		if(toLocal!=null){
			dateConverted = Instant.ofEpochMilli(toLocal.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
		}
		return dateConverted;
	}
}
