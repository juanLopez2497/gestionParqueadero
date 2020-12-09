package com.ceiba.gestionParqueadero.dominio.unitaria;

import java.util.List;

import org.assertj.core.api.AssertDelegateTarget;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import com.ceiba.gestionParqueadero.dominio.ActividadEjecutar;
import com.ceiba.gestionParqueadero.dominio.ActividadResumen;
import com.ceiba.gestionParqueadero.dominio.repositorio.IActividadRepository;
import com.ceiba.gestionParqueadero.dominio.servicio.actividad.ServicioCrearActividadParqueo;
import com.ceiba.gestionParqueadero.dominio.servicio.actividad.ServicioObtenerActividadAutomotor;

import om.ceiba.gestionParqueadero.testDataBuilder.ActividadTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActividadTest {
	@InjectMocks
	ServicioCrearActividadParqueo servicioCrearActividadParqueo;
	@InjectMocks
	ServicioObtenerActividadAutomotor servicioObtenerActividadAutomotor;
	@Mock
	IActividadRepository actividadRepository;
	
	@Test
	public void listActividadesAutomotorActivas(){
		List<ActividadResumen> listActividades=new ActividadTestDataBuilder().listActividadesAutomotorActivas();
		
		when(actividadRepository.listActividadesActivas()).thenReturn(listActividades);
		
		List<ActividadResumen> listActividadesReturned=servicioObtenerActividadAutomotor.listActividadesAutomotorActivas();
		
		assertTrue(!listActividadesReturned.isEmpty());
	}
	@Test
	public void CrearActividadParqueo(){
		ActividadResumen actividad= new ActividadTestDataBuilder().actividadCreada();
		ActividadEjecutar actividadEjecutar= new ActividadTestDataBuilder().generaActividadEjecutar();
		
		when(actividadRepository.agregarActividad(actividadEjecutar)).thenReturn(actividad);
		
		ActividadResumen actividadReturned=servicioCrearActividadParqueo.CrearActividadParqueo(actividadEjecutar);
		assertTrue(actividadReturned.getPlaca().equals(actividad.getPlaca()));
	}

}
