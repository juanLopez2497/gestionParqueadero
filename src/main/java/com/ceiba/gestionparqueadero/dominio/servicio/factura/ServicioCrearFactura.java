package com.ceiba.gestionparqueadero.dominio.servicio.factura;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


import org.springframework.stereotype.Component;

import com.ceiba.gestionparqueadero.dominio.ActividadResumen;
import com.ceiba.gestionparqueadero.dominio.FacturaInicializar;
import com.ceiba.gestionparqueadero.dominio.FacturaResumen;
import com.ceiba.gestionparqueadero.dominio.repositorio.ActividadRepository;
import com.ceiba.gestionparqueadero.dominio.repositorio.FacturaRepository;

@Component
public class ServicioCrearFactura {
	
	private static final double TARIFA_HORA_CARRO=2000;
	private static final double TARIFA_HORA_MOTO=1000;
	private static final double PORCENTAJE_AUMENTO_DESC_10=0.10;
	private static final double PORCENTAJE_AUMENTO_5=0.05;
	private static final int MAX_HOUR=23;
	private static final int MAX_MINUTE=59;
	private static final int MINUTOS_TO_HORAS=60;
	
	private final FacturaRepository facturaRepository;
	private final ActividadRepository actividadRepository; 
	
	public ServicioCrearFactura(FacturaRepository factura, ActividadRepository actividadRepository){
		this.facturaRepository=factura;
		this.actividadRepository=actividadRepository;
	}
	
	public FacturaResumen crearFactura(FacturaInicializar facturaInicializar){
		ActividadResumen actividadResumen=actividadRepository.buscarById(facturaInicializar.getId());
		double pagoParcial=0;
		double totalAumentos=0;
		double totalAPagar=0;

		double horasTotalesParqueo=calcularHorasTotalesParqueo(actividadResumen.getHoraEntra(), facturaInicializar.getFechaSalida());
		Long conteoDomingos=contarDomingos(actividadResumen.getHoraEntra(), facturaInicializar.getFechaSalida());
		pagoParcial=calcularTarifa( horasTotalesParqueo, actividadResumen.getTipo());
		
		if(validarDiaEntraSale(actividadResumen.getHoraEntra(), facturaInicializar.getFechaSalida())){
				if(isDomingo(facturaInicializar.getFechaSalida())){
					if(facturaInicializar.getFlagBonoDescuento()!=null && ("A").equals(facturaInicializar.getFlagBonoDescuento())){
						pagoParcial=(pagoParcial-(pagoParcial*PORCENTAJE_AUMENTO_DESC_10));
					}else{
						pagoParcial=calcularAumentoEnDomingo(pagoParcial, actividadResumen.getTipo());
					}
				}
		}else{
			if(conteoDomingos!=0L){
				totalAumentos=calcularSobreCostoDomingos(actividadResumen.getHoraEntra(), facturaInicializar.getFechaSalida(),conteoDomingos,
						actividadResumen.getTipo());
			}
		}
		
		totalAPagar=pagoParcial+totalAumentos;
		FacturaResumen facturaToPersist= new FacturaResumen(actividadResumen.getIdActRegistro(),
				actividadResumen.getPlaca(),totalAPagar);

			return facturaRepository.crearRegistro(facturaToPersist);
	}
	public boolean validarDiaEntraSale(LocalDateTime fechaEntra, LocalDateTime fechaSale){
		boolean result=false;
		if(fechaEntra.getDayOfYear()==fechaSale.getDayOfYear()){
			result= true;
		}
		return result;
	}
	public double calcularHorasTotalesParqueo(LocalDateTime fechaEntra, LocalDateTime fechaSale){
		long minutes = ChronoUnit.MINUTES.between(fechaEntra,fechaSale);
		return Math.ceil((minutes/(double)MINUTOS_TO_HORAS));
	}
	
	public double calcularTarifa(double horas,String tipo){
		double result=0;
		if("C".equals(tipo)){
			result=horas*TARIFA_HORA_CARRO;
		}else if("M".equals(tipo)){
			result=horas*TARIFA_HORA_MOTO;
		}
		return result;
	}
	public boolean isDomingo(LocalDateTime fechaSale){
		boolean result=false;
		if(fechaSale.getDayOfWeek()==DayOfWeek.SUNDAY){
			result=true;
		}
		return result;
	}
	public Long contarDomingos(LocalDateTime fechaEntra, LocalDateTime fechaSale){
		
		Long contadorDomingos=0L;
				
		while(fechaEntra.getDayOfYear()<=fechaSale.getDayOfYear()){
			if(fechaEntra.getDayOfWeek()==DayOfWeek.SUNDAY){
				contadorDomingos++;
			}
			fechaEntra=fechaEntra.plusDays(1);
		}
		return contadorDomingos;
	}
	
	public double calcularSobreCostoDomingos(LocalDateTime fechaEntra, LocalDateTime fechaSale, Long countDomingos, String tipo){

		LocalDateTime diaEntraMax=fechaEntra;
		LocalDateTime diaSaleMin=fechaSale;
	
		double tiempoExtraFirst=0;
		double tiempoExtraLast=0;
		double tiempoMiddle=0;
		
		double sobreCosto=0;
		
		if(fechaEntra.getDayOfWeek()==DayOfWeek.SUNDAY){
			diaEntraMax=diaEntraMax.withHour(MAX_HOUR);
			diaEntraMax=diaEntraMax.withMinute(MAX_MINUTE);
			tiempoExtraFirst=Math.ceil((ChronoUnit.MINUTES.between(fechaEntra, diaEntraMax)/(double)MINUTOS_TO_HORAS));
			countDomingos--;
		}
		if(fechaSale.getDayOfWeek()==DayOfWeek.SUNDAY){
			diaSaleMin=diaSaleMin.withHour(0);
			diaSaleMin=diaSaleMin.withMinute(0);
			tiempoExtraLast=Math.ceil(ChronoUnit.MINUTES.between(diaSaleMin,fechaSale)/(double)MINUTOS_TO_HORAS);
			countDomingos--;
		}
		if(countDomingos!=0){
			tiempoMiddle=(24*(double)countDomingos);
		}
		sobreCosto=(tiempoExtraFirst+tiempoMiddle+tiempoExtraLast);
		
		if("C".equals(tipo)){
			sobreCosto=((sobreCosto)*TARIFA_HORA_CARRO)*PORCENTAJE_AUMENTO_DESC_10;
		}else if("M".equals(tipo)){
			sobreCosto=((sobreCosto)*TARIFA_HORA_MOTO)*PORCENTAJE_AUMENTO_5;
		}
		return sobreCosto;
	}
	
	public double calcularAumentoEnDomingo(double pagoParcial, String tipo){
		if(("C").equals(tipo)){
			pagoParcial=(pagoParcial+(pagoParcial*PORCENTAJE_AUMENTO_DESC_10));
		}else if(("M").equals(tipo)){
			pagoParcial=(pagoParcial+(pagoParcial*PORCENTAJE_AUMENTO_5));
		}
		return pagoParcial;
	}
}
