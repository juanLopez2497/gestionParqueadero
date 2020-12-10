package com.ceiba.gestionparqueadero.dominio.servicio.factura;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
		
		SimpleDateFormat dateRestores=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateEntra = null;
		try {
			dateEntra=dateRestores.parse(actividadResumen.getHoraEntra());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double horasTotalesParqueo=calcularHorasTotalesParqueo(dateEntra, facturaInicializar.getFechaSalida());
		Long conteoDomingos=contarDomingos(dateEntra, facturaInicializar.getFechaSalida());
		pagoParcial=calcularTarifa( horasTotalesParqueo, actividadResumen.getTipo());
		if(validarDiaEntraSale(dateEntra, facturaInicializar.getFechaSalida())){
				if(isDomingo(facturaInicializar.getFechaSalida())){
					if(facturaInicializar.getFlagBonoDescuento()!=null && ("A").equals(facturaInicializar.getFlagBonoDescuento())){
						pagoParcial=(pagoParcial-(pagoParcial*PORCENTAJE_AUMENTO_DESC_10));
					}else{
						if(("C").equals(actividadResumen.getTipo())){
							pagoParcial=(pagoParcial+(pagoParcial*PORCENTAJE_AUMENTO_DESC_10));
						}else if(("M").equals(actividadResumen.getTipo())){
							pagoParcial=(pagoParcial+(pagoParcial*PORCENTAJE_AUMENTO_5));
						}
					}
				}
		}else{
			if(conteoDomingos!=0L){
				totalAumentos=calcularSobreCostoDomingos(dateEntra, facturaInicializar.getFechaSalida(),conteoDomingos,
						actividadResumen.getTipo());
			}
		}
		
		totalAPagar=pagoParcial+totalAumentos;
		FacturaResumen facturaToPersist= new FacturaResumen(actividadResumen.getIdActRegistro(),
				actividadResumen.getPlaca(),totalAPagar);

			return facturaRepository.crearRegistro(facturaToPersist);
	}
	public boolean validarDiaEntraSale(Date fechaEntra, Date fechaSale){
		Calendar diaEntra=Calendar.getInstance();
		Calendar diaSale=Calendar.getInstance();
		
		diaEntra.setTime(fechaEntra);
		diaSale.setTime(fechaSale);
		
		if(diaEntra.get(Calendar.DAY_OF_YEAR)==diaSale.get(Calendar.DAY_OF_YEAR)){
			return true;
		}
		
		return false;
	}
	public double calcularHorasTotalesParqueo(Date fechaEntra, Date fechaSale){
		double totalTiempoParqueo=fechaSale.getTime()-fechaEntra.getTime();
		return Math.ceil(totalTiempoParqueo/3600000);
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
	public boolean isDomingo(Date fechaSale){
		Calendar diaSale=Calendar.getInstance();
		diaSale.setTime(fechaSale);
		if(diaSale.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY){
			return false;
		}
		return true;
	}
	public Long contarDomingos(Date fechaEntra, Date fechaSale){
		Calendar diaEntra=Calendar.getInstance();
		Calendar diaSale=Calendar.getInstance();
		
		diaEntra.setTime(fechaEntra);
		diaSale.setTime(fechaSale);
		
		Long contadorDomingos=0L;
				
		while(diaEntra.get(Calendar.DAY_OF_YEAR)<=diaSale.get(Calendar.DAY_OF_YEAR)){
			if(diaEntra.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
				contadorDomingos++;
			}
			diaEntra.add(Calendar.DAY_OF_YEAR,1);
		}
		
		return contadorDomingos;
	}
	
	public double calcularSobreCostoDomingos(Date fechaEntra, Date fechaSale, Long countDomingos, String tipo){
		Calendar diaEntra=Calendar.getInstance();
		Calendar diaSale=Calendar.getInstance();
		Calendar diaEntraMax=Calendar.getInstance();
		Calendar diaSaleMin=Calendar.getInstance();
		
		diaEntra.setTime(fechaEntra);
		diaSale.setTime(fechaSale);
		diaEntraMax.setTime(fechaEntra);
		diaSaleMin.setTime(fechaSale);
		
		double tiempoExtraFirst=0;
		double tiempoExtraLast=0;
		double tiempoMiddle=0;
		
		double sobreCosto=0;
		
		if(diaEntra.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
			diaEntraMax.set(Calendar.HOUR_OF_DAY, 24);
			diaEntraMax.set(Calendar.MINUTE, 00);
			tiempoExtraFirst=Math.ceil(((diaEntraMax.getTime()).getTime()-(diaEntra.getTime()).getTime())/3600000);
			countDomingos--;
		}
		if(diaSale.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
			diaSaleMin.set(Calendar.HOUR_OF_DAY, 00);
			diaSaleMin.set(Calendar.MINUTE, 00);
			tiempoExtraLast=Math.ceil(((diaSale.getTime()).getTime()-(diaSaleMin.getTime()).getTime())/3600000);
			countDomingos--;
		}
		if(countDomingos!=0){
			tiempoMiddle=24*countDomingos;
		}
		sobreCosto=(tiempoExtraFirst+tiempoMiddle+tiempoExtraLast);
		
		if("C".equals(tipo)){
			sobreCosto=((tiempoExtraFirst+tiempoMiddle+tiempoExtraLast)*TARIFA_HORA_CARRO)*PORCENTAJE_AUMENTO_DESC_10;
		}else if("M".equals(tipo)){
			sobreCosto=((tiempoExtraFirst+tiempoMiddle+tiempoExtraLast)*TARIFA_HORA_MOTO)*PORCENTAJE_AUMENTO_5;
		}
		return sobreCosto;
	}
}
