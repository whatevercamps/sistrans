package vos;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 *Clase que representa un operador de tipo vivienda Universitaria,
 *su responsabilidades son las de un operador admeas de :
 *-Brindar los servicios de sala de estudio, Gimnasio,Restaurante,Sala de esparcimiento
 *es obligación de esta clase si estos tienen un precio adicional
 */


public class ViviendaUniversitaria extends Operadores
{
	/**
	 * Servicio de sala de estudio si su valor es 0 no tiene costo adicional
	 */
	@JsonProperty(value="ServicioSalaDeEstudioPrecioAdicional")
	protected double ServicioSalaDeEstudioPrecioAdicional;
	/**
	 * Servicio de gimnasio si su valor es 0 no tiene costo adicional
	 */
	@JsonProperty(value="ServicioGymPrecioAdicional")
	protected double ServicioGymPrecioAdicional;

	/**
	 * Servicio de restaurante si su valor es 0 no tiene costo adicional
	 */
	@JsonProperty(value="RestaurantePrecioAdicional")
	protected double RestaurantePrecioAdicional;
	/**
	 * Servicio de sala de esparcimiento si su valor es 0 no tiene costo adicional
	 */ 
	@JsonProperty(value="SalaDeEsparcimientoPrecioAdicional")
	protected double SalaDeEsparcimientoPrecioAdicional;

	public ViviendaUniversitaria(@JsonProperty(value="Nombre")String nombre,
			@JsonProperty(value="Tipo") int tipo,
			@JsonProperty(value="MinDeTiempo") double minTiempo,
			@JsonProperty(value="Capacidad")double capacidad
			,@JsonProperty(value="id") Long id,@JsonProperty(value="RestaurantePrecioAdicional") double precioRestaurante
			,@JsonProperty(value="ServicioGymPrecioAdicional") double precioGym,
			@JsonProperty(value="ServicioSalaDeEstudioPrecioAdicional") double precioSalaDeEstudio,
			@JsonProperty(value="SalaDeEsparcimientoPrecioAdicional")double precioEsparcimiento)
	{
		super(nombre,tipo,minTiempo,capacidad,id);
		this.ServicioSalaDeEstudioPrecioAdicional=precioSalaDeEstudio;
		this.ServicioGymPrecioAdicional=precioGym;
		this.RestaurantePrecioAdicional=precioRestaurante;
		this.SalaDeEsparcimientoPrecioAdicional=precioEsparcimiento;
	}
	/**
	 * 
	 * @return precio servico sala de estudio 
	 */
	private double getServicioSalaDeEstudioPrecioAdicional() {
		return this.ServicioSalaDeEstudioPrecioAdicional;
	}

	/**
	 * 
	 * @return precio servicio de gym
	 */
	private double getServicioGymPrecioAdicional() {
		return this.ServicioGymPrecioAdicional;
	}
	/**
	 * 
	 * @return precio servicio de restaurante
	 */

	private double getRestaurantePrecioAdicional() {
		return this.RestaurantePrecioAdicional;
	}
	/**
	 * 
	 * @return precio servicio sala de esparcimiento
	 */

	private double getSalaDeEsparcimientoPrecioAdicional() {
		return this.SalaDeEsparcimientoPrecioAdicional;
	}

	/**
	 * 
	 * @param myServicioSalaDeEstudioPrecioAdicional nuevo precio
	 */
	private void setServicioSalaDeEstudioPrecioAdicional(double myServicioSalaDeEstudioPrecioAdicional) {
		this.ServicioSalaDeEstudioPrecioAdicional = myServicioSalaDeEstudioPrecioAdicional;
	}
	/**
	 * 
	 * @param myServicioGymPrecioAdicional nuevo precio
	 */

	private void setServicioGymPrecioAdicional(double myServicioGymPrecioAdicional) {
		this.ServicioGymPrecioAdicional = myServicioGymPrecioAdicional;
	}
	/**
	 * 
	 * @param myRestaurantePrecioAdicional nuevo precio
	 */

	private void setRestaurantePrecioAdicional(double myRestaurantePrecioAdicional) {
		this.RestaurantePrecioAdicional = myRestaurantePrecioAdicional;
	}

	/**
	 * 
	 * @param mySalaDeEsparcimientoPrecioAdicional nuevo precio
	 */
	private void setSalaDeEsparcimientoPrecioAdicional(double mySalaDeEsparcimientoPrecioAdicional) 
	{
		this.SalaDeEsparcimientoPrecioAdicional = mySalaDeEsparcimientoPrecioAdicional;
	}


}

