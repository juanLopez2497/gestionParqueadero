package com.ceiba.gestionparqueadero.dominio.unitaria;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.gestionparqueadero.dominio.dto.ActividadResumenDTO;
import com.ceiba.gestionparqueadero.dominio.repositorio.ActividadRepository;
import com.ceiba.gestionparqueadero.dominio.servicio.actividad.ServicioObtenerActividadAutomotor;
import com.ceiba.gestionparqueadero.testdatabuilder.ActividadTestDataBuilder;

@RunWith(SpringRunner.class)
public class ObtenerActividadAutomotorTest {
	
	@InjectMocks
	ServicioObtenerActividadAutomotor servicioObtenerActividadAutomotor;
	@Mock
	ActividadRepository actividadRepository;
	
	@Test
	public void listActividadesAutomotorActivas(){
		List<ActividadResumenDTO> listActividades=new ActividadTestDataBuilder().listActividadesAutomotorActivas();
		
		when(actividadRepository.listActivas()).thenReturn(listActividades);
		
		List<ActividadResumenDTO> listActividadesReturned=servicioObtenerActividadAutomotor.listActividadesAutomotorActivas();
		
		assertTrue(!listActividadesReturned.isEmpty());
	}
}
