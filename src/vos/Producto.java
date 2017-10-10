/**-------------------------------------------------------------------
 * $Id$
 * Universidad de los Andes (BogotÃ¡ - Colombia)
 * Departamento de IngenierÃ­a de Sistemas y ComputaciÃ³n
 *
 * Materia: Sistemas Transaccionales
 * Ejercicio: RotondAndes
 * Autor: Juan Carlos Corrales - jc.corrales@uniandes.edu.co
 * -------------------------------------------------------------------
 */
package vos;

import java.util.List;

import org.codehaus.jackson.annotate.*;


public class Producto extends ProductoBase
{
	

	/**
	 * Costo de Producciódel producto.
	 */
	@JsonProperty(value="costoDeProduccion")
	private Double costoDeProduccion;
	/**
	 * Descripcion en español del producto.
	 */
	@JsonProperty(value = "descripcionEspaniol")
	private String descripcionEspaniol;
	
	/**
	 * Descripcion en Inglés del producto.
	 */
	@JsonProperty(value = "descripcionIngles")
	private String descripcionIngles;
	/**
	 * Atributo que contiene los IDs de los productos equivalentes.
	 */
	@JsonProperty(value = "productosEquivalentes")
	private List<ProductoBase> productosEquivalentes;
	/**
	 * Atributo que contiene el precio.
	 */
	@JsonProperty(value = "precio")
	private Double precio;
	/**
	 * Atributo que contiene los tipos de comida.
	 */
	@JsonProperty(value = "tiposComida")
	private List<TipoComida> tiposComida;
	
	/**
	 * Método constructor de la clase Producto.
	 * @param id
	 * @param nombre
	 * @param costoDeProduccion
	 * @param descripcionEspaniol
	 * @param descripcionIngles
	 * @param idProductosEquivalentes
	 * @param precio
	 * @param tiposComida
	 */
	
	public Producto() {
		super();
	}
	
	public Producto(Long id, String nombre, Double costoDeProduccion,String descripcionEspaniol, String descripcionIngles, List<ProductoBase> productosEquivalentes, Double precio, List<TipoComida> tiposComida){
		super(id, nombre);
		this.costoDeProduccion = costoDeProduccion;
		this.descripcionEspaniol = descripcionEspaniol;
		this.descripcionIngles = descripcionIngles;
		this.productosEquivalentes = productosEquivalentes;
		this.precio = precio;
		this.tiposComida = tiposComida;
		
	}
	


	/**
	 * Método que obtiene el costo de producción.
	 * @return Double, Costo de producción de este Producto.
	 */
	public Double getCostoDeProduccion()
	{
		return this.costoDeProduccion;
	}
	/**
	 * Método que establece el costo de producción de este producto.
	 * @param costoDeProduccion Double, Nuevo costo de producción.
	 */
	public void setCostoDeProduccion(Double costoDeProduccion)
	{
		this.costoDeProduccion = costoDeProduccion;
	}
	/**
	 * Método que obtiene la descripción de este producto en español.
	 * @return String, descripción del producto en español.
	 */
	public String getDescripcionEspaniol()
	{
		return this.descripcionEspaniol;
	}
	/**
	 * Método que establece la descripción de este producto en español.
	 * @param descripcionEspaniol String, Nueva descripción del producto en español.
	 */
	public void setDescripcionEspaniol(String descripcionEspaniol)
	{
		this.descripcionEspaniol = descripcionEspaniol;
	}
	/**
	 * Método que obtiene la descripción de este producto en ingles.
	 * @return String, descripción del producto en español.
	 */
	public String getDescripcionIngles()
	{
		return this.descripcionIngles;
	}
	/**
	 * Método que establece la descripción de este producto en español.
	 * @param descripcionEspaniol String, Nueva descripción del producto en ingles.
	 */
	public void setDescripcionIngles(String descripcionIngles)
	{
		this.descripcionIngles = descripcionIngles;
	}
	/**
	 * Método que obtiene el precio de este producto.
	 * @return
	 */
	public Double getPrecio()
	{
		return this.precio;
	}
	/**
	 * Método que establece el precio de este producto.
	 * @param precio Double, Precio nuevo del producto.
	 */
	public void setPrecio(Double precio)
	{
		this.precio = precio;
	}
	/**
	 * Método que obtiene los IDs de los productos equivalentes a este.
	 * @return List<Long>, Lista de IDs de productos Equivalentes.
	 */
	public List<ProductoBase> getIdProductosEquivalentes()
	{
		return productosEquivalentes;
	}
	/**
	 * Método que establece una lista de IDs de productos equivalentes a este.
	 * @param idProductosEquivalentes List<Long>, Lista de IDs de productos equivalentes.
	 */
	public void setIdProductosEquivalentes(List<ProductoBase> productosEquivalentes)
	{
		this.productosEquivalentes = productosEquivalentes;
	}
	/**
	 * Método que obtiene los tipos de comida de este producto.
	 * @return List<String>, Tipos de comida de este producto.
	 */
	public List<TipoComida> getTiposComida()
	{
		return this.tiposComida;
	}
	/**
	 * Método que obtiene los tipos de comida.
	 * @param tiposComida
	 */
	public void setTiposComida(List<TipoComida> tiposComida)
	{
		this.tiposComida = tiposComida;
	}
}
