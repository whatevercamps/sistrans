/**-------------------------------------------------------------------
 * $Id$
 * Universidad de los Andes (BogotÃ¡ - Colombia)
 * Departamento de IngenierÃ­a de Sistemas y ComputaciÃ³n
 *
 * Materia: Sistemas Transaccionales
 * Ejercicio: menuAndes
 * Autor: Juan Felipe GarcÃ­a - jf.garcia268@uniandes.edu.co
 * -------------------------------------------------------------------
 */
package vos;

import java.util.Collection;

import org.codehaus.jackson.annotate.*;

/**
 * Clase que representa un menú
 * @author dj.bautista10
 */
public class Menu{

	//// Atributos

	/**
	 * Id del menu
	 */
	@JsonProperty(value="id")
	private Long id;

	/**
	 * Nombre del menú
	 */
	@JsonProperty(value="name")
	private String name;

	/**
	 * Costo de producción
	 */
	@JsonProperty(value="costoProduccion")
	private Double costoProduccion;

	@JsonProperty(value="descripcion")
	private String descripcion;

	@JsonProperty(value="description")
	private String description;


	@JsonProperty(value="precio")
	private Double precio;

	@JsonProperty(value="entrada")
	private Entrada entrada; 

	@JsonProperty(value="platoFuerte")
	private PlatoFuerte platoFuerte;

	@JsonProperty(value="postre")
	private Postre postre;

	@JsonProperty(value="bebida")
	private Bebida bebida;


	/**
	 * Método constructor de la clase menu
	 * <b>post: </b> Crea el menu con los valores que entran como parametro
	 * @param id - Id del menu.
	 * @param name - Nombre del menu. name != null
	 * @param sabores - lista de String de sabores en minutos del menu.
	 */
	public Menu(@JsonProperty(value="id") Long id, 
			@JsonProperty(value="name") String name, 
			@JsonProperty(value = "costoProduccion") Double costoProduccion, 
			@JsonProperty(value="descripcion") String descripcion, 
			@JsonProperty(value = "description") String description, 
			@JsonProperty(value = "precio") Double precio,
			@JsonProperty(value="entrada") Entrada entrada,
			@JsonProperty(value="platoFuerte") PlatoFuerte platoFuerte,
			@JsonProperty(value="bebida") Bebida bebida,
			@JsonProperty(value="postre") Postre postre){
		super();
		this.id = id;
		this.name = name;
		this.descripcion = descripcion;
		this.description = description;
		this.precio = precio;
		this.costoProduccion = costoProduccion;
		this.entrada = entrada;
		this.platoFuerte = platoFuerte;
		this.bebida = bebida;
		this.postre = postre;
	}


	/**
	 * Metodo getter del atributo id
	 * @return id del menu
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo setter del atributo id <b>post: </b> El id del menu ha sido
	 * cambiado con el valor que entra como parametro
	 * @param id - Id del menu
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo getter del atributo name
	 * @return nombre del menu
	 */
	public String getName() {
		return name;
	}

	/**
	 * Metodo setter del atributo name <b>post: </b> El nombre del menu ha sido
	 * cambiado con el valor que entra como parametro
	 * @param name - Id del menu
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Método getter del atributo sabores
	 * @return colección de sabores del menu 
	 */
	public  String getDescripcion() {
		return descripcion;
	}

	/**
	 * Método setter del atributo esCaliente <b> post: </b> El valor condicional de la bebida ha sido cambiado
	 * por el valor que entra como parámetro.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion= descripcion;
	}



	/**
	 * Método getter del atributo sabores
	 * @return colección de sabores del menu 
	 */
	public  String getdescription() {
		return description;
	}

	/**
	 * Método setter del atributo esCaliente <b> post: </b> El valor condicional de la bebida ha sido cambiado
	 * por el valor que entra como parámetro.
	 */
	public void setdescription(String description) {
		this.description= description;
	}


	public Double getPrecion() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getCostoProduccion() {
		return costoProduccion;
	}

	public void setCostoProduccion(Double costoProduccion) {
		this.costoProduccion = costoProduccion;
	}
	
	public Entrada getEntrada() {
		return entrada;
	}
	
	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}
	
	public PlatoFuerte getPlatoFuerte() {
		return platoFuerte;
	}

	public void setPlatoFuerte(PlatoFuerte platoFuerte) {
		this.platoFuerte = platoFuerte;
	}
	
	public Postre getPostre() {
		return postre;
	}
	
	public void setPostre(Postre postre) {
		this.postre = postre;
	}
	
	public Bebida getBebida() {
		return bebida;
	}
	
	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}
}
