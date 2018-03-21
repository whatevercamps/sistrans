package vos;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Hostal extends Operadores
{
	
	@JsonProperty(value="HoraApertura")
	protected String HoraApertura;	
	@JsonProperty(value="HoraClausura")
	protected String HoraClausura;


	public Hostal(@JsonProperty(value="Nombre")String nombre,
			@JsonProperty(value="Tipo") int tipo,
			@JsonProperty(value="MinDeTiempo") double minTiempo,
			@JsonProperty(value="Capacidad")double capacidad
			,@JsonProperty(value="id") Long id,
			@JsonProperty(value="HoraApertura") String horaA,
			@JsonProperty(value="HoraClausura") String horaC)
	{
		super(nombre,tipo,minTiempo,capacidad,id);
		this.HoraApertura=horaA;
		this.HoraClausura=horaC;
		
	}


	private String getHoraApertura() {
		return this.HoraApertura;
	}


	private String getHoraClausura() {
		return this.HoraClausura;
	}


	private void setHoraApertura(String myHoraApertura) {
		this.HoraApertura = myHoraApertura;
	}


	private void setHoraClausura(String myHoraClausura) {
		this.HoraClausura = myHoraClausura;
	}


}

