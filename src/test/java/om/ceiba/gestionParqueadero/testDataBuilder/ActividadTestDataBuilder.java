package om.ceiba.gestionParqueadero.testDataBuilder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.ceiba.gestionParqueadero.aplicacion.comando.ComandoRegistroParqueo;
import com.ceiba.gestionParqueadero.dominio.ActividadEjecutar;
import com.ceiba.gestionParqueadero.dominio.ActividadResumen;

public class ActividadTestDataBuilder {
	private static final Long ID_ACTIVIDAD=999L;
	private static final Date HORA_ENTRA=new GregorianCalendar(2020, Calendar.DECEMBER, 
			6, 10, 25, 00).getTime();
	private static final String HORA_ENTRA_CADENA="2020-12-08 21:00:00";
	private static final String ESTADO="A";
	
	private static final Long ID_AUTOMOTOR=999L;
	private static final String PLACA="WXZ09C";
	private static final String ANOTACION="Entra con espejo IZQ roto";
	private static final String TIPO="M";
	
	private static final String PLACA_NUEVO="WXZ08C";
	private static final String ANOTACION_NUEVO="Entra con espejo derecho roto";
	
	private Long idActividad;
	private Date horaEntra;
	private String horaEntraCadena;
	private String estado;
	private long idAtomotor;
	private String placa;
	private String anotacion;
	private String tipo;
	private String placaNuevo;
	private String anotacionNuevo;
	private String tipoNuevo;
	
	public ActividadTestDataBuilder(){
		this.idActividad=ID_ACTIVIDAD;
		this.horaEntra=HORA_ENTRA;
		this.horaEntraCadena=HORA_ENTRA_CADENA;
		this.estado=ESTADO;
		
		this.idAtomotor=ID_AUTOMOTOR;
		this.placa=PLACA;
		this.anotacion=ANOTACION;
		this.tipo=TIPO;
		
		this.placaNuevo=PLACA_NUEVO;
		this.anotacionNuevo=ANOTACION_NUEVO;
	}
	
	public List<ActividadResumen> listActividadesAutomotorActivas(){
		List<ActividadResumen> lisActResumen = new ArrayList<>();
		ActividadResumen actividad=new ActividadResumen(this.horaEntraCadena, this.placa, this.anotacion, this.tipo, this.idActividad);
		lisActResumen.add(actividad);
		return lisActResumen;
	}
	
	public ActividadResumen actividadCreada(){
		ActividadResumen actividad=new ActividadResumen(this.horaEntraCadena, this.placa, this.anotacion, this.tipo, this.idActividad);
		return actividad;
	}
	
	public ActividadEjecutar generaActividadEjecutar(){
		ActividadEjecutar actividadEjecutar=new ActividadEjecutar(this.placa, this.anotacion, this.tipo);
		return actividadEjecutar;
	}
	public ComandoRegistroParqueo creaActividad(){
		return new ComandoRegistroParqueo(placaNuevo, anotacionNuevo, tipo);
	}
	

}
