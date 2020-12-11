package com.ceiba.gestionparqueadero.dominio.unitaria;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.gestionparqueadero.dominio.ActividadEjecutar;
import com.ceiba.gestionparqueadero.dominio.ActividadResumen;
import com.ceiba.gestionparqueadero.dominio.repositorio.ActividadRepository;
import com.ceiba.gestionparqueadero.dominio.servicio.actividad.ServicioCrearActividadParqueo;
import com.ceiba.gestionparqueadero.dominio.servicio.actividad.ServicioObtenerActividadAutomotor;
import com.ceiba.gestionparqueadero.testDataBuilder.ActividadTestDataBuilder;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ActividadTest {
	@InjectMocks
	ServicioCrearActividadParqueo servicioCrearActividadParqueo;
	@InjectMocks
	ServicioObtenerActividadAutomotor servicioObtenerActividadAutomotor;
	@Mock
	ActividadRepository actividadRepository;
	
	@Test
	public void listActividadesAutomotorActivas(){
		List<ActividadResumen> listActividades=new ActividadTestDataBuilder().listActividadesAutomotorActivas();
		
		when(actividadRepository.listActivas()).thenReturn(listActividades);
		
		List<ActividadResumen> listActividadesReturned=servicioObtenerActividadAutomotor.listActividadesAutomotorActivas();
		
		assertTrue(!listActividadesReturned.isEmpty());
	}
	@Test
	public void CrearActividadParqueo(){
		ActividadResumen actividad= new ActividadTestDataBuilder().actividadCreada();
		ActividadEjecutar actividadEjecutar= new ActividadTestDataBuilder().generaActividadEjecutar();
		
		when(actividadRepository.agregar(actividadEjecutar)).thenReturn(actividad);
		
		ActividadResumen actividadReturned=servicioCrearActividadParqueo.crearActividadParqueo(actividadEjecutar);
		assertEquals(actividadReturned.getPlaca(),actividad.getPlaca());
	}

}
