package vos;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Esta clase representa un servicio adicinal , el cual hace parate de una propuesta, ejemplos de servicios adicionales son:
 * -Jacuzzi,piscina,ect..
 */

public class Servicios_Adicionales
{
	/**
	 * Nombre de un servicio adicional
	 * 
	 */
	@JsonProperty(value="Nombre")
	protected String Nombre;
	/**
	 * Costo del servicio adicional si es igual a cero se entiende que no tiene costo adicional 
	 */
	@JsonProperty(value="Costo")
	protected double Costo;

	/**
	 * Identificador de un servicio adicional cada id es unico
	 */
	@JsonProperty(value="id")
	protected Long id;

	public Servicios_Adicionales(@JsonProperty(value="Nombre")String nombre,@JsonProperty(value="Costo") double costo,@JsonProperty(value="id") Long id) 
	{
		
		this.Nombre = nombre;
		this.Costo = costo;
		this.id = id;
	}

	/**
	 * 
	 * @retur nombre de la entidad
	 */
	private String getNombre() {
		return this.Nombre;
	}

	/**
	 * 
	 * @return costo del servicio
	 */
	private double getCosto() {
		return this.Costo;
	}
/**
 * 
 * @return el identificador del servicio adicional
 */
	public long getId() {
		return this.id;
	}

	/**
	 * 
	 * @param myNombre nuevo nombre para la entidad
	 */
	private void setNombre(String myNombre) {
		this.Nombre = myNombre;
	}

	/**
	 * 
	 * @param myCosto nuevo costo para el servicio adicional
	 */
	private void setCosto(double myCosto) {
		this.Costo = myCosto;
	}

	

}

