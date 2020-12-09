package com.ceiba.gestionParqueadero.infraestructura.persistencia.builder;

import com.ceiba.gestionParqueadero.dominio.FacturaResumen;
import com.ceiba.gestionParqueadero.infraestructura.persistencia.entity.FacturaEntity;

public class FacturaBuilder {
	
	private FacturaBuilder(){
		
	}
	public static FacturaEntity convertirToFacturaEntity(FacturaResumen facturaPersist){
		FacturaEntity facturaEntity=new FacturaEntity();
		
		facturaEntity.setValorPagado(facturaPersist.getValorPagado());
		facturaEntity.setIdActividadEntity(facturaPersist.getIdAct());
		return facturaEntity;
	}

}
