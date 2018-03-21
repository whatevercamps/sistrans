package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class HabitacionHotel extends Operadores
{	//Atributos
	@JsonProperty(value="CodigoSuperIntendencia")
	protected String CodigoSuperIntendecnia;	
	@JsonProperty(value="TipoHabitacion")
	protected String TipoHabitacion;
	@JsonProperty(value="Capacidad")
	protected double Capacidad;
	@JsonProperty(value="Tamanio")
	protected String Tamanio;

	public HabitacionHotel(@JsonProperty(value="Nombre")String nombre,
			@JsonProperty(value="Tipo") int tipo,
			@JsonProperty(value="MinDeTiempo") double minTiempo,
			@JsonProperty(value="Capacidad")double capacidad
			,@JsonProperty(value="id") Long id,
			@JsonProperty(value="CodigoSuperIntendencia") String codigo,@JsonProperty(value="TipoHabitacion") String tipoH
			,@JsonProperty(value="Capacidad") double capacidadH,
			@JsonProperty(value="Tamanio") String tamanio)
	{
		super(nombre,tipo,minTiempo,capacidad,id);
		this.CodigoSuperIntendecnia=codigo;
		this.TipoHabitacion=tipoH;
		this.Capacidad=capacidadH;
		this.Tamanio=tamanio;

	}
	//Metodos

	private String getCodigoSuperInetndecnia() {
		return this.CodigoSuperIntendecnia;
	}


	private String getTipoHabitacion() {
		return this.TipoHabitacion;
	}

	private double getCapacidad() {
		return this.Capacidad;
	}

	private String getTamanio() {
		return this.Tamanio;
	}


	private void setCodigoSuperInetndecnia(String myCodigoSuperInetndecnia) {
		this.CodigoSuperIntendecnia = myCodigoSuperInetndecnia;
	}


	private void setTipoHabitacion(String myTipoHabitacion) {
		this.TipoHabitacion = myTipoHabitacion;
	}


	private void setCapacidad(double myCapacidad) {
		this.Capacidad = myCapacidad;
	}


	private void setTamanio(String myTamanio) {
		this.Tamanio = myTamanio;
	}


}

