package vos;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
/**
 * Representa una reserva sirve entre intermediario entre un cliente y un operador 
 */
public class Reserva {
	//Atributos
	/**
	 * Fecha inicio de la reserva
	 */
	@JsonProperty(value="FechaInicial")
	protected Date FechaInicial;
	/**
	 * Fecha final de reserva
	 */
	@JsonProperty(value="FechaFinal")
	protected Date FechaFinal;
	
	/**
	 * Ultima fecha pa cancelar reserva antes de penalizacion
	 */
	@JsonProperty(value="FcehaConvenienteDeCancelacion")
	protected Date FechaConvenienteDeCanelacion;
	//Asociacion
	/**
	 * Representa las propuesta con una reserva
	 */
	@JsonProperty(value="Propuesta")
	protected Propuesta Propuesta;
	/**
	 *Identificador de una reserva cada identificador es unica 
	 */
	@JsonProperty(value="id")
	protected Long id;

	//Cosntructor 
	public Reserva(@JsonProperty(value="FechaConvenienteDeCancelacion")Date fechaConvenineteDeCancelacion,@JsonProperty(value="FechaInicial")Date fechaInicial,@JsonProperty(value="FechaFinal")Date fechaFinal,	@JsonProperty(value="id")Long id,@JsonProperty(value="Propuesta")Propuesta propuesta)
	{
		this.FechaConvenienteDeCanelacion=fechaConvenineteDeCancelacion;
		this.FechaInicial=fechaInicial;
		this.FechaFinal=fechaFinal;
		
		this.id=id;
		if(propuesta!=null)
		this.Propuesta=propuesta;
	}

	//Metodo getter y setter
	/**
	 * 
	 * @return La fecha inicial en la cual comienza una reserva
	 */
	private Date getFechaInicial()
	{
		return this.FechaInicial;
	}
	/**
	 * 
	 * @return La fecha final en la cual acaba una reserva
	 */

	private Date getFechaFinal() {
		return this.FechaFinal;
	}

	
	/**
	 * 
	 * @return ultima feha antes de ser sancionado 
	 */

	private Date getFechaConvenienteDeCanelacion() {
		return this.FechaConvenienteDeCanelacion;
	}

	/**
	 * 
	 * @return propuesta asociada a una reserva
	 */
	public Propuesta getPropuesta() {
		return this.Propuesta;
	}

	/**
	 * 
	 * @return id de una reserva
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * 
	 * @param myFechaInicial nueva fecha de una reserva
	 */
	private void setFechaInicial(Date myFechaInicial) {
		this.FechaInicial = myFechaInicial;
	}

	/**
	 * 
	 * @param myFechaFinal nueva fecha final de una reserva
	 */
	private void setFechaFinal(Date myFechaFinal) {
		this.FechaFinal = myFechaFinal;
	}

	

	/**
	 * 
	 * @param myFechaConvenienteDeCanelacion nueva fecha cancelacion
	 */
	private void setFechaConvenienteDeCanelacion(Date myFechaConvenienteDeCanelacion) {
		this.FechaConvenienteDeCanelacion = myFechaConvenienteDeCanelacion;
	}

	/**
	 * 
	 * @param myPropuesta nueva propuesta asociada a una reserva
	 */
	public void setPropuesta(Propuesta myPropuesta) {
		this.Propuesta = myPropuesta;
	}




}



