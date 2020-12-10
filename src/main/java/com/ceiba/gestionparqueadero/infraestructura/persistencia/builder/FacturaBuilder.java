package com.ceiba.gestionparqueadero.infraestructura.persistencia.builder;

import com.ceiba.gestionparqueadero.dominio.FacturaResumen;
import com.ceiba.gestionparqueadero.infraestructura.persistencia.entity.FacturaEntity;

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
