package com.ceiba.gestionparqueadero.infraestructura.persistencia.builder;

import com.ceiba.gestionparqueadero.dominio.dto.FacturaResumenDTO;
import com.ceiba.gestionparqueadero.infraestructura.persistencia.entity.FacturaEntity;

public final class FacturaBuilder {
	
	private FacturaBuilder(){
		
	}
	public static FacturaEntity convertirToFacturaEntity(FacturaResumenDTO facturaPersist){
		FacturaEntity facturaEntity=new FacturaEntity();
		
		facturaEntity.setValorPagado(facturaPersist.getValorPagado());
		facturaEntity.setIdActividadEntity(facturaPersist.getIdAct());
		return facturaEntity;
	}

}
