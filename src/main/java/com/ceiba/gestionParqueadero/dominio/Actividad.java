package com.ceiba.gestionParqueadero.dominio;


public class Actividad {
	
	private String horaEntra;
	
	private String horaSale;
		
	private RegistroAutomotor registroAutomotor;
	
	private String estado;

	public String getHoraEntra() {
		return horaEntra;
	}

	public String getHoraSale() {
		return horaSale;
	}

	public RegistroAutomotor getRegistroAutomotor() {
		return registroAutomotor;
	}

	public String getEstado() {
		return estado;
	}
}
