package com.ceiba.gestionParqueadero.infraestructura.persistencia.builder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.ceiba.gestionParqueadero.dominio.Actividad;
import com.ceiba.gestionParqueadero.dominio.ActividadEjecutar;
import com.ceiba.gestionParqueadero.dominio.ActividadResumen;
import com.ceiba.gestionParqueadero.infraestructura.persistencia.entity.ActividadEntity;
import com.ceiba.gestionParqueadero.infraestructura.persistencia.entity.RegistroAutomotorEntity;

public class ActividadBuilder {
	
	private ActividadBuilder(){
		
	}
	
	public static ActividadResumen convertirToActividadDTO(ActividadEntity actividadEntity){
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fechaCast=dateFormat.format(actividadEntity.getHoraEntra());
		return new ActividadResumen(fechaCast, actividadEntity.getRegistroAutomotorEntity().getPlaca(),
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
		actividadEntity.setHoraEntra(actividadEjecutar.getFechaEntra());
		actividadEntity.setRegistroAutomotorEntity(regAutomotor);
		
		return actividadEntity;
	}
}
