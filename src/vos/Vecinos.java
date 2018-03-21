package vos;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Representa un tipo de operador de tipo vecino, el cual cumple con :
 * -Participa en la comunidad uniandina
 * -Vive por los alrededores de la univeridad
 * -Posee una vivienda la cual es presentada en una propuesta 
 */

public class Vecinos extends Operadores
{
	//Atributos
	/**
	 * Este atributo describe el seguro y en el se describen restricciones y limitaciones
	 */
	@JsonProperty(value="CaracteristicasDelSeguro")
	protected String CaracteristicasDelSeguro;

	public Vecinos(@JsonProperty(value="Nombre")String nombre,
			@JsonProperty(value="Tipo") int tipo,
			@JsonProperty(value="MinDeTiempo") double minTiempo,
			@JsonProperty(value="Capacidad")double capacidad
			,@JsonProperty(value="id") Long id,@JsonProperty(value="CaracteristicasDelSeguro")String seguro)
	{
		super(nombre,tipo,minTiempo,capacidad,id);
		this.CaracteristicasDelSeguro=seguro;
	}

	//Getters setters y unsetters
	/**
	 * 
	 * @return caracteristicas del seguro
	 */
	private String getCaracteristicasDelSeguro() {
		return this.CaracteristicasDelSeguro;
	}

	/**
	 * 
	 * @param myCaracteristicasDelSeguro nuevas caracteristicas del seguro
	 */
	private void setCaracteristicasDelSeguro(String myCaracteristicasDelSeguro) {
		this.CaracteristicasDelSeguro = myCaracteristicasDelSeguro;
	}


}

