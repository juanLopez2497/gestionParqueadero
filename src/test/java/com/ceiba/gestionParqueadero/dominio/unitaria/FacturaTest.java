package com.ceiba.gestionParqueadero.dominio.unitaria;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.gestionParqueadero.dominio.ActividadResumen;
import com.ceiba.gestionParqueadero.dominio.repositorio.IFactura;
import com.ceiba.gestionParqueadero.dominio.servicio.factura.ServicioCrearFactura;

import om.ceiba.gestionParqueadero.testDataBuilder.ActividadTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacturaTest {
	
	private static final Date HORA_ENTRA=new GregorianCalendar(2020, Calendar.DECEMBER, 
			6, 10, 25, 00).getTime();
	private static final Date HORA_SALE=new GregorianCalendar(2020, Calendar.DECEMBER, 
			6, 11, 40, 00).getTime();
	private static final Date HORA_SALE_DIFERENTE=new GregorianCalendar(2020, Calendar.DECEMBER, 
			7, 11, 40, 00).getTime();
	private static final Date ES_DOMINGO=new GregorianCalendar(2020, Calendar.DECEMBER, 
			6, 11, 40, 00).getTime();
	private static final int TOTAL_HORAS_PARQUEO=2;
	
	
	@InjectMocks
	ServicioCrearFactura servicioCrearFactura;
	@Mock
	IFactura facturaRepository;
	
	@Test
	public void validarDiaEntraSale(){
		
		boolean result=servicioCrearFactura.validarDiaEntraSale(HORA_ENTRA, HORA_SALE);
		
		assertTrue(result);
	}
	
	@Test
	public void validarDiaEntraSaleDiferente(){
		
		boolean result=servicioCrearFactura.validarDiaEntraSale(HORA_ENTRA, HORA_SALE_DIFERENTE);
		
		assertFalse(result);
	}
	
	@Test
	public void CalcularHorasTotalesParqueo(){
		
		int horasParqueo=(int) servicioCrearFactura.CalcularHorasTotalesParqueo(HORA_ENTRA, HORA_SALE);
		assertEquals(horasParqueo, TOTAL_HORAS_PARQUEO);
	}
	
	@Test
	public void calcularTarifaMoto(){
		double tarifaPagar=2000;
		double tarifaParcial=servicioCrearFactura.calcularTarifa(2, "M");
		assertEquals(tarifaParcial, tarifaPagar, 0);
	}
	@Test
	public void calcularTarifaCarro(){
		double tarifaPagar=4000;
		double tarifaParcial=servicioCrearFactura.calcularTarifa(2, "C");
		assertEquals(tarifaParcial, tarifaPagar, 0);
	}
	@Test
	public void isDomingo(){
		boolean isTrue=servicioCrearFactura.isDomingo(ES_DOMINGO);
		assertTrue(isTrue);
	}
	@Test
	public void isNotDomingo(){
		boolean isFalse=servicioCrearFactura.isDomingo(HORA_SALE_DIFERENTE);
		assertFalse(isFalse);
	}
	@Test
	public void contarDomingos(){
		long result=servicioCrearFactura.contarDomingos(HORA_ENTRA, HORA_SALE_DIFERENTE);
		assertEquals(result,1L);
	}
	@Test
	public void calcularSobreCostoDomingos(){
		double SobreCostoPrecalculado=650;
		double sobreCostoDomingo=servicioCrearFactura.calcularSobreCostoDomingos(HORA_ENTRA, HORA_SALE_DIFERENTE, 1L, "M");
		assertEquals(sobreCostoDomingo, SobreCostoPrecalculado, 0);
	}
}
