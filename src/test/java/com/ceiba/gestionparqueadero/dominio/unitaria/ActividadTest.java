package com.ceiba.gestionparqueadero.dominio.unitaria;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.gestionparqueadero.dominio.dto.ActividadResumenDTO;
import com.ceiba.gestionparqueadero.dominio.excepcion.ParqueaderoLlenoException;
import com.ceiba.gestionparqueadero.dominio.modelo.ActividadEjecutar;
import com.ceiba.gestionparqueadero.dominio.repositorio.ActividadRepository;
import com.ceiba.gestionparqueadero.dominio.servicio.actividad.ServicioCrearActividadParqueo;
import com.ceiba.gestionparqueadero.testdatabuilder.ActividadTestDataBuilder;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.List;

@RunWith(SpringRunner.class)
public class ActividadTest {
	@InjectMocks
	ServicioCrearActividadParqueo servicioCrearActividadParqueo;
	@Mock
	ActividadRepository actividadRepository;
	
	@Test
	public void crearActividadParqueo(){
		ActividadResumenDTO actividad= new ActividadTestDataBuilder().actividadCreada();
		ActividadEjecutar actividadEjecutar= new ActividadTestDataBuilder().generaActividadEjecutar();
		
		when(actividadRepository.agregar(actividadEjecutar)).thenReturn(actividad);
		
		ActividadResumenDTO actividadReturned=servicioCrearActividadParqueo.crearActividadParqueo(actividadEjecutar);
		assertEquals(actividadReturned.getPlaca(),actividad.getPlaca());
	}
	
	@Test(expected = ParqueaderoLlenoException.class)
	public void validarCupoParqueaderoTest(){
		Long maxCupoDef=4L;
		List<ActividadResumenDTO> lisActResumen= new ActividadTestDataBuilder().listActividadesAutomotorLimiteCupo();
		
		when(actividadRepository.listActivas()).thenReturn(lisActResumen);
		servicioCrearActividadParqueo.validarCupoParqueadero(maxCupoDef);
	}
}
