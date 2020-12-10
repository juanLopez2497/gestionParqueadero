package com.ceiba.gestionparqueadero.dominio;

public class ActividadResumen {
	
	private String horaEntra;
	
	private String placa;
	
	private String anotacion;
	
	private String tipo;
	
	private Long idActRegistro;
	
	public ActividadResumen(String horaEntra, String placa, String anotacion, String tipo, Long idActRegistro) {
		this.horaEntra=horaEntra;
		this.placa=placa;
		this.anotacion=anotacion;
		this.tipo=tipo;
		this.idActRegistro=idActRegistro;
	}
	

	public String getHoraEntra() {
		return horaEntra;
	}


	public void setHoraEntra(String horaEntra) {
		this.horaEntra = horaEntra;
	}


	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getAnotacion() {
		return anotacion;
	}

	public void setAnotacion(String anotacion) {
		this.anotacion = anotacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getIdActRegistro() {
		return idActRegistro;
	}
	public void setIdActRegistro(Long idActRegistro) {
		this.idActRegistro = idActRegistro;
	}
	
}
