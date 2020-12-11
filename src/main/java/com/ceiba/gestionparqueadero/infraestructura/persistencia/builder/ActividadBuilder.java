package com.ceiba.gestionparqueadero.infraestructura.persistencia.builder;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.ceiba.gestionparqueadero.dominio.ActividadEjecutar;
import com.ceiba.gestionparqueadero.dominio.ActividadResumen;
import com.ceiba.gestionparqueadero.infraestructura.persistencia.entity.ActividadEntity;
import com.ceiba.gestionparqueadero.infraestructura.persistencia.entity.RegistroAutomotorEntity;

public class ActividadBuilder {
	
	private ActividadBuilder(){
		
	}
	
	public static ActividadResumen convertirToActividadDTO(ActividadEntity actividadEntity){
		return new ActividadResumen(convertDateToLocal(actividadEntity.getHoraEntra()), actividadEntity.getRegistroAutomotorEntity().getPlaca(),
				actividadEntity.getRegistroAutomotorEntity().getAnotacion(), actividadEntity.getRegistroAutomotorEntity().getTipo(),
				actividadEntity.getId());
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
		
		return actividadEntity;
	}
	public static Date convertLocalToDate(LocalDateTime toDate){
		if(toDate!=null){
			return Date.from(toDate.atZone(ZoneId.systemDefault()).toInstant());
		}
		return null;
	}
	
	public static  LocalDateTime convertDateToLocal(Date toLocal){
		if(toLocal!=null){
			return Instant.ofEpochMilli(toLocal.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
		}
		return null;
	}
}
