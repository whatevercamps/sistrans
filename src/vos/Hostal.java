package vos;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import java.time.LocalDateTime;
public class Hostal extends Operadores
{
	
	@JsonProperty(value="HoraApertura")
	protected LocalDateTime HoraApertura;	
	@JsonProperty(value="HoraClausura")
	protected LocalDateTime HoraClausura;


	public Hostal(@JsonProperty(value="Nombre")String nombre,
			@JsonProperty(value="Tipo") int tipo,
			@JsonProperty(value="MinDeTiempo") double minTiempo,
			@JsonProperty(value="Capacidad")double capacidad
			,@JsonProperty(value="id") Long id,
			@JsonProperty(value="HoraApertura") LocalDateTime horaA,
			@JsonProperty(value="HoraClausura") LocalDateTime horaC)
	{
		super(nombre,tipo,minTiempo,capacidad,id);
		this.HoraApertura=horaA;
		this.HoraClausura=horaC;
		
	}


	private LocalDateTime getHoraApertura() {
		return this.HoraApertura;
	}


	private LocalDateTime getHoraClausura() {
		return this.HoraClausura;
	}


	private void setHoraApertura(String myHoraApertura) {
		this.HoraApertura = myHoraApertura;
	}


	private void setHoraClausura(String myHoraClausura) {
		this.HoraClausura = myHoraClausura;
	}


}

