package com.ceiba.gestionparqueadero.dominio.unitaria;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.gestionparqueadero.dominio.repositorio.FacturaRepository;
import com.ceiba.gestionparqueadero.dominio.servicio.factura.ServicioCrearFactura;


@RunWith(SpringRunner.class)
public class FacturaTest {
	
	private static final LocalDateTime HORA_ENTRA=LocalDateTime.of(2020, 12, 6, 10, 25, 0);
	private static final LocalDateTime HORA_SALE=LocalDateTime.of(2020, 12, 6, 11, 40, 0);
	private static final LocalDateTime HORA_SALE_DIFERENTE=LocalDateTime.of(2020, 12, 7, 11, 40, 0);
	private static final LocalDateTime ES_DOMINGO=LocalDateTime.of(2020, 12, 6, 11, 40, 0);

	private static final int TOTAL_HORAS_PARQUEO=2;
	
	
	@InjectMocks
	ServicioCrearFactura servicioCrearFactura;
	@Mock
	FacturaRepository facturaRepository;
	
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
		
		int horasParqueo=(int) servicioCrearFactura.calcularHorasTotalesParqueo(HORA_ENTRA, HORA_SALE);
		assertEquals(TOTAL_HORAS_PARQUEO, horasParqueo);
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
		assertEquals(1L,result);
	}
	@Test
	public void calcularSobreCostoDomingos(){
		double SobreCostoPrecalculado=700;
		double sobreCostoDomingo=servicioCrearFactura.calcularSobreCostoDomingos(HORA_ENTRA, HORA_SALE_DIFERENTE, 1L, "M");
		assertEquals(sobreCostoDomingo, SobreCostoPrecalculado, 0);
	}
}
