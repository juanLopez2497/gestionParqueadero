package om.ceiba.gestionParqueadero.testDataBuilder;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ceiba.gestionParqueadero.aplicacion.comando.ComandoGeneracionFactura;
import com.ceiba.gestionParqueadero.dominio.FacturaInicializar;

public class FacturaTestDataBuilder {
	
	private static final Long ID_REG_ACTIVIDAD=999L;
	private static final Long ID_REG_ACTIVIDAD_NO_EXISTE=10L;
	private static final String FLAG_BONO_DESCUENTO="N";
	private static final String PLACA="WXZ09C";
	private static final double TOTAL_PAGADO=34000;
	private static final Date HORA_ENTRA=new GregorianCalendar(2020, Calendar.DECEMBER, 
			6, 10, 25, 00).getTime();
	private static final Date HORA_SALE=new GregorianCalendar(2020, Calendar.DECEMBER, 
			6, 11, 40, 00).getTime();
	
	private Long idRegActividad;
	private Long idRegActividadNoExiste;
	private String flagBono;
	private String placa;
	private double TotalPagar;
	private Date horaEntra;
	private Date horaSale;
	
	public FacturaTestDataBuilder(){
		this.idRegActividad=ID_REG_ACTIVIDAD;
		this.flagBono=FLAG_BONO_DESCUENTO;
		this.placa=PLACA;
		this.TotalPagar=TOTAL_PAGADO;
		this.horaEntra=HORA_ENTRA;
		this.horaSale=HORA_SALE;
		this.idRegActividadNoExiste=ID_REG_ACTIVIDAD_NO_EXISTE;
	}
	
	public ComandoGeneracionFactura inicializaFactura(){
		return new ComandoGeneracionFactura(idRegActividad, placa, flagBono);
	}
	public ComandoGeneracionFactura inicializaFacturaFail(){
		return new ComandoGeneracionFactura(idRegActividadNoExiste, placa, flagBono);
	}
	
}
